package DemoRMI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	private static final String FILENAME = "E:/Users/Ýbrahim/Desktop/Staj/WorkSpace/RMI-GUI/WriterMessages.txt";

	public static Writer writeToFile(Event FileEvent) {
		try {
			
			String content = FileEvent.serialize().toString();
			File file = new File(FILENAME);
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content + " ");
			if("WriterMessages.txt" != null){
				bw.newLine();
			}
			bw.close();
		}
		 catch (IOException e) {
			
			e.printStackTrace();
			
		}
		return null;
		}
	
	}
