package DemoRMI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	private static final String FILENAME = "WriterMessages.txt";

	public static Writer writeToFile(String content) {
		
		try {

			File file = new File(FILENAME);
			
			FileWriter fw = new FileWriter(file, true);
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(content + " ");
			
			if ("WriterMessages.txt" != null) {
				
				bw.newLine();
			}
			
			bw.close();
			
		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;
	}

}
