package org.elsysbg.ip.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpGetExample {
	
	private static final String HTTP_HOST = "example.com";
	private static final String HTTP_METHOD_GET = "GET";
	private static final String HTTP_PATH = "/index.html";
	private static final String PROTOCOL_VERSION = "HTTP/1.1";
	private static final String LOCATION_HEADER_NAME = "Location";
	private static final int HTTP_PORT = 80;
	private static final int MOVED_PERMANENTLY = 301;
	private static final int MOVED_TEMPORARILY = 302;

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		final HttpGetExample example = new HttpGetExample();
		final CharacterHttpResponse response = example.createRequest(
				HTTP_HOST, HTTP_METHOD_GET, HTTP_PATH);

		System.out.println(new String(response.getStatusLine()));
		for (HttpHeader next : response.getHeaders()) {
			System.out.printf("%s: %s\n", next.getName(), next.getValue());
		}
		System.out.println(new String(response.getBody()));
	}

	public CharacterHttpResponse createRequest(String host, String method,
			String path) throws UnknownHostException, IOException {
		final Socket clientSocket = new Socket(host, HTTP_PORT);
		try {
			final InputStream inputStream = clientSocket.getInputStream();
			final OutputStream outputStream = clientSocket.getOutputStream();

			final InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			final BufferedReader in = new BufferedReader(inputStreamReader);
			final PrintWriter out = new PrintWriter(outputStream);

			writeRequest(out, host, method, path);
			out.flush();

			return parseResponse(in, method, path);
		} finally {
			clientSocket.close();
		}

	}

	private CharacterHttpResponse parseResponse(BufferedReader in, String method, String path)
			throws IOException {
		final CharacterHttpResponse result = new CharacterHttpResponse();
		result.setStatusLine(in.readLine());
		
		String StatusLineCode = result.getStatusLine();
		String[] splitted = StatusLineCode.split(" ", 3);
		int code = Integer.parseInt(splitted[1]);
		
		String next;
		while (!(next = in.readLine()).equals("")) {
			result.getHeaders().add(HttpHeader.createFromHeaderLine(next));
		}
		
		String headerValue = null;
//		String location = null;
		if((code == MOVED_PERMANENTLY) || (code == MOVED_TEMPORARILY)) {
			for(HttpHeader headerNext : result.getHeaders()) {
				if(headerNext.equals(LOCATION_HEADER_NAME)) {
					headerValue = headerNext.getValue();
					headerValue = headerValue.replaceAll("http://", "");
					headerValue = headerValue.replaceAll(path, "");
				}
			}
			return createRequest(headerValue, method, path);
		}
		
		in.read(result.getBody());
		return result;
	}

	private void writeRequest(PrintWriter out, String host, String method,
			String path) {
		out.printf("%s %s %s\n", method, path, PROTOCOL_VERSION);
		out.printf("Host: %s\n", host);
		out.printf("\n");
	}

}