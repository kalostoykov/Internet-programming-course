import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientH {
	public static final String SERVER_NAME = "localhost";
	
	public static void main(String[] args) throws IOException {
		System.out.println("Enter date: ");
		final InputStream input = System.in;
		final InputStreamReader inputStreamReader = new InputStreamReader(input);
		final BufferedReader reader = new BufferedReader(inputStreamReader);
		final String request = reader.readLine();
		
		final Socket clientSocket = new Socket(SERVER_NAME, ServerH.SERVER_PORT);
		
		final InputStream inputStream = clientSocket.getInputStream();
		final OutputStream outputStream = clientSocket.getOutputStream();
		final InputStreamReader inputStreamReader2 = new InputStreamReader(
				inputStream);
		final BufferedReader in = new BufferedReader(inputStreamReader2);
		final PrintWriter out = new PrintWriter(outputStream);
		
		out.println(request);
		
		out.flush();
		
		final String result = in.readLine();
		
		clientSocket.close();
		
		System.out.println(result);
	}
}
