import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

// Each client connection will be managed in a thread;
public class JavaHTTPServer implements Runnable {
	
	static final File WEB_ROOT = new File(".");
	static final String DEFAULT_FILE = "index.html";
	static final String FILE_NOT_FOUND = "404.html";
	static final String METHOD_NOT_SUPPORTED = "not_supported.html";
	//port
	static final int PORT = 8080;
	
	//verbose
	
	static final boolean verbose = true;
	
	//Client connection via socket
	
	private Socket connect;
	
	public JavaHTTPServer(Socket c) {
		connect = c;
	}
	
	public static void main (String[] args) {
		try {
			ServerSocket serverConnect = new ServerSocket (PORT);
			System.out.println("Server started.\nListening for connections on port : " + PORT + "...\n");
			
			// loops until user halts connection
			while (true) {
				JavaHTTPServer myServer = new JavaHTTPServer(serverConnect.accept());
				
				if (verbose) {
					System.out.println("Connection opened (" + new Date() + ")");
				}
				
				// dedicate a thread to manage the client connection
				
				Thread thread = new Thread(myServer);
				thread.start();
			}
		} catch (IOException e) {
			System.err.println("Server connection error: " + e.getMessage());
		}
	}

	@Override
	public void run() {
		// manage our client connection
		
		
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedOutputStream bos = null;
		String fileRequested = null;
		
		try {
			//reads characters from the client
			in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			// characters output stream to client
			out = new PrintWriter(connect.getOutputStream());
			//get output stream to cliient (for requested data)
			bos = new BufferedOutputStream(connect.getOutputStream());
			
			//get first line of the request from the client
			
			String input = in.readLine();
			
			// parse the request with a string tokeziner
			StringTokenizer parse = new StringTokenizer(input);
			String method = parse.nextToken().toUpperCase(); // get the HTTP method of the client
			//get the file requested
			fileRequested = parse.nextToken().toLowerCase();
			
			// only get and head methods
			
			if (!method.equals("GET") && !method.equals("HEAD")) {
				if (verbose) {
					System.out.println("501 not implemented: " + method + "method");
				}
				
				//return the not supported file to client
				File file = new File(WEB_ROOT, METHOD_NOT_SUPPORTED);
				int fileLength = (int) file.length();
				String contentMimeType = "text/html";
				//read content to return to client
				byte[] fileData = readFileData(file, fileLength);
				
				//send HTTP header with data to client
				out.println("HTTP/1.1 501 Not Implemented");
				out.println("Server : Java HTTP server from : 1.0");
				out.println("Date: " + new Date());
				out.println("Content-type: " + contentMimeType);
				out.println("Content-length " + fileLength);
				out.println(); //blank line between headers and content
				out.flush();
				
				bos.write(fileData, 0, fileLength);
				bos.flush();
				
			} else {
				//GET or HEAD method
				
				if (fileRequested.endsWith("/")) {
					fileRequested += DEFAULT_FILE;
				}
				
				File file = new File(WEB_ROOT, fileRequested);
				int fileLength = (int) file.length();
				String content = getContentType(fileRequested);
				
				if(method.equals("GET")) { // GET method
					byte[] fileData = readFileData(file, fileLength);
						
					//SEND HTTP headers
					out.println("HTTP/1.1 200 OK");
					out.println("Server : Java HTTP server from : 1.0");
					out.println("Date: " + new Date());
					out.println("Content-type: " + content);
					out.println("Content-length " + fileLength);
					out.println(); //blank line between headers and content
					out.flush();
					
					bos.write(fileData, 0, fileLength); 
					bos.flush();
				}
				
				if (verbose) {
					System.out.println("File " + fileRequested + " of type: " + content + " returned");
				}
				
			}
			
		} catch (FileNotFoundException fnfe) {
			try {
				fileNotFound(out, bos, fileRequested);
			} catch (IOException ioe) {
				System.err.println("Error with file not found exception: " + ioe.getMessage());
			}
			
			
			
		} catch (IOException e) {
			System.err.println("Server error: "+ e);
		} finally {
			try {
				in.close();
				out.close();
				bos.close();
				connect.close(); //close socket connection
			} catch (Exception e) {
				System.err.println("error closing stream: " + e.getMessage());
			} 
			
			if (verbose) {
				System.out.println("connection closed\n");
			}
		}
	}
	
	private byte[] readFileData(File file, int fileLength) throws IOException {
		FileInputStream fis = null;
		byte[] fileData = new byte[fileLength];
		
		try {
		fis = new FileInputStream(file);
		fis.read(fileData);
		} finally {
			if (fis!= null) {
				fis.close();
			}
		}
		
		return fileData;
		
	}
	
	//return MIME types
	private String getContentType(String fileRequested) {
		if(fileRequested.endsWith(".htm") || fileRequested.endsWith(".html")) 
			return "text/html";
		else 
			return "text/plain";
			
		}
	
	private void fileNotFound(PrintWriter out, OutputStream bos, String fileRequested) throws IOException {

		File file = new File(WEB_ROOT, FILE_NOT_FOUND);
		int fileLength = (int) file.length();
		String content = "text/html";
		byte[] fileData = readFileData(file, fileLength);
		
		out.println("HTTP/1.1 404 file not found");
		out.println("Server : Java HTTP server from : 1.0");
		out.println("Date: " + new Date());
		out.println("Content-type: " + content);
		out.println("Content-length " + fileLength);
		out.println(); //blank line between headers and content
		out.flush();
		
		bos.write(fileData, 0, fileLength);
		bos.flush();
		
		if(verbose) {
			System.out.println("File " + fileRequested + "not found");
		}

	}
}
