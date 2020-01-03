package kjlasdhf;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ReadFile {
	File path = new File(WritingToFiles.pathLocation.toString());
	Scanner scanner;

	public void openFile() throws FileNotFoundException {
		// Directs the Scanner to the path of the file set in Writing to Files.
		scanner = new Scanner(path);

	}

	public ArrayList<String> readCommandValues() throws IOException {
		try {
			FileReader file = new FileReader(path);
			BufferedReader reader = new BufferedReader(file);
			
			ArrayList<String> stringArrList = new ArrayList<String>();
			
			for(String line = reader.readLine(); line !=null; line = reader.readLine()) {
				String[] tempSplit = line.split(":");
				stringArrList.add(tempSplit[0]);
				stringArrList.add(tempSplit[1]);
			}
			
			return stringArrList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
