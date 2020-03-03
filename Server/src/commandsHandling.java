import java.io.*;
import java.util.ArrayList;


public class commandsHandling {
	private static String COMMANDSFILE;
	private static ArrayList<Command> commandsList = new ArrayList<>();
	long oldsize;
	
	public commandsHandling(File file) throws NumberFormatException, IOException {
		COMMANDSFILE= file.getAbsolutePath();
		new checkFile().init(file);
		
	}

	public static ArrayList<Command> getCommands() {
		return commandsList;
	}

	public class checkFile extends Thread {
		File f1;
		public void init(File file) {
			f1=file;
			start();
		}
		
		
		@Override
		public void run() { 
			try {
				long oldsize=0;
				while(true) {
					long newsize=f1.length();
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(COMMANDSFILE)));
					if(newsize>oldsize) {
						ArrayList<Command> commandsListTemp = new ArrayList<>();
						String tempStr;
						while ((tempStr = reader.readLine()) != null) {
							String[] words = tempStr.split(";");
							if (words.length == 5) {
								Command tempCommands = new Command(words[0], words[1], Double.valueOf(words[2]),
									Double.valueOf(words[3]), Integer.valueOf(words[4]));
								commandsListTemp.add(tempCommands);
							}
						}
						commandsList.clear();
						commandsList.addAll(commandsListTemp);
						oldsize=newsize;
					
					}
				}
			}
			
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}
}
