import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset; 
//import java.nio.file.FileSystems;
//import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Server {
	private static final String CLOSE_COMMAND = "CLOSE";
	private static final int PORT = 4444;

	public static void main(String[] args) throws IOException {

boolean closing = false;
	try (ServerSocket serverSocket = new ServerSocket(PORT)) {
		System.out.println("Started server on port " + PORT);

while (!closing) {

try (Socket clientSocket = serverSocket.accept()) {
	System.out.println("Accepted connection from client: "+ clientSocket);

		InputStream inStream = clientSocket.getInputStream();
		OutputStream outStream = clientSocket.getOutputStream();

		try (BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
			PrintWriter out = new PrintWriter(outStream, true); {

	String s = in.readLine(); 

LinkedList<String> lines = new LinkedList<String>(); 
while (!s.equals("")) { 
lines.add(s);
s = in.readLine(); 
}

String[] parts = lines.get(0).split(" ");
System.out.println(parts[0]);
boolean file_exists = new File(".\\sources_html\\"+ parts[1]).exists();

switch (parts[0]) {
	case parts[0] == "GET":
		if (parts[1] == "index.html") {
/*List<String> file = (ArrayList<String>) Files.readAllLines(FileSystems.getDefault().getPath("sources_html", parts[1]), Charset.defaultCharset());
Iterator<String> it = file.iterator();
while (it.hasNext()) {
out.write((String) it.next());*/
			out.write("200 OK");
		}
		else {
			out.write("404 NOT FOUND");
}
	
break;
case "PUT":
file_exists = new File(".\\sources_html\\" + parts[1]).exists(); 
if (file_exists) { 
out.write("403 FORBIDDEN");
} else {
out.write("404 NOT FOUND");
}
break;
case "POST":
file_exists = new File(".\\sources_html\\" + parts[1]).exists(); 
if (file_exists) {
out.write("403 FORBIDDEN");
} else {
out.write("404 NOT FOUND");
}
break;
case "DELETE":
file_exists = new File(".\\sources_html\\" + parts[1]).exists();
if (file_exists) {
out.write("403 FORBIDDEN");
} else {
out.write("404 NOT FOUND");
}
break;
default:
out.write("501 Not Implemented");
}

    }
  }
  }
  }
  }
  }
