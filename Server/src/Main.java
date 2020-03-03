import java.io.File;
import java.io.IOException;


public class Main {

	
	//private static final String COMMANDS = "commandList.txt";

	public static void main(String[] args) throws NumberFormatException, IOException {
		int PORT = 24091;
		File file = new File("src/commandList.txt");
		commandsHandling commands = new commandsHandling(file);
		ServerStart server = new ServerStart(PORT);
		server.runServer();
	}
}


