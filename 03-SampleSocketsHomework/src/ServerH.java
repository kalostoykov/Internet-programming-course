import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class ServerH {
	public static final int SERVER_PORT = 44012;
	private boolean started;
	
	public class ClientHandler extends Thread  {
		private final Socket clientSocket;

		public ClientHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			
			try {
				final InputStream inputStream = clientSocket.getInputStream();
				final OutputStream outputStream = clientSocket.getOutputStream();
				
				final InputStreamReader inputStreamReader = new InputStreamReader(
						inputStream);
				final BufferedReader in = new BufferedReader(inputStreamReader);
				final PrintWriter out = new PrintWriter(outputStream);
				
				final String readLine = in.readLine();
				
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        try {
					Date dateStr = formatter.parse(readLine);
					long diff = new Date().getTime() - dateStr.getTime();
					long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
					out.println(days);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
				out.flush();
				
				clientSocket.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		new ServerH().run();
	}
	
	public void run() throws IOException {
		started = true;
		final ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
		
		while(started) {
			final Socket clientSocket = serverSocket.accept();
			
			new ClientHandler(clientSocket).start();
		}
		
		serverSocket.close();
	}
}
