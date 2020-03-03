
import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import java.util.ArrayList;

public class StartClient extends JFrame {
	static ArrayList<Command> commands = new ArrayList<>();

	public StartClient() {}
		
	public void setup() {
		setSize(600, 600);
        setTitle("Test");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

		
	}
	public static  void main(String[] args) {
		StartClient drawingBoardApp= new StartClient();
				drawingBoardApp.setup();
		try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 24091), 10000);
			drawingBoardApp.new ClientThread().setClient(socket,drawingBoardApp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
		
	
	

    public class ClientThread extends Thread{
    	Socket socket;
    	StartClient drawingBoardApp;
    	
    	public ClientThread() {
		}
    	void setClient(Socket socket,StartClient  drawingBoardApp ) {
    		this.socket=socket;
    		this.drawingBoardApp= drawingBoardApp;
    		start();
    		
    	}
    	
    	@Override
		public void run() {
    		
    		
    		try {
    			ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());
				while(true) {
    		
			
				
	            commands = (ArrayList<Command>)objIn.readObject();
	            drawingBoardApp.add(new Paint(commands));
	            drawingBoardApp.setVisible(true);
	            //System.out.println( "cl"+ commands.size());
			}
    		}catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
            
    		}
		}
    	
    	
    }
}

