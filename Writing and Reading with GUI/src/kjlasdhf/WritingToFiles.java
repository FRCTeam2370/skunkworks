package kjlasdhf;
import java.io.*;
import java.util.*;

public class WritingToFiles {
	
	static Command[] commands = new Command[4];
	static File pathLocation = new File("Auto2.txt");
	ReadFile fileReader = new ReadFile();
	
	public static void main(String[] args) throws
	IOException {
		OutputStream outputStream = new OutputStream(pathLocation);
		ObjectOutputStream objectOutputSteam = new ObjectOutputStream(outputStream);
		
		PrintWriter printer = new PrintWriter(pathLocation);
		commands[0] = new DriveForwards(10.00);
		commands[1] = new DriveBackwards(10.00);
		commands[2] = new TurnLeft(87.00);
		commands[3] = new TurnRight(70.00);
		
		for(int i = 0; i < commands.length; i++) {
			printer.println(commands[i].getName() + ":" + commands[i].getValue());
			
		}
		
		printer.flush();
		printer.close();
		
		fileReader.openFile();
		
		


		
	}
}
