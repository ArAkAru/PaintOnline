import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServerStart {
	private int PORT;
	public ServerStart(int PORT) {
		this.PORT = PORT;
		//System.out.println(commands.getCommands().size());
	}

	public void runServer() {
		try {
			ServerSocket srvSocket = new ServerSocket(PORT);
			System.out.println("Server started...");

			while (true) {
				Socket socket = srvSocket.accept();
				new ServerThread().setClient(socket);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public class ServerThread extends Thread {
		private Socket socket;

		public ServerThread() {
		}

		public void setClient(Socket socket) {
			System.out.println("Servicing client...");
			this.socket = socket;
			start();
		}

		@Override
		public void run() {
		
			try {
				
				ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
				while(true) {
					ArrayList<Command> commandsList = new ArrayList<>();
					commandsList.addAll(commandsHandling.getCommands());
					objOut.writeObject(commandsList);
					objOut.flush();
					sleep(500);
					
				}

			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
				
			}
		}
		}

	}


