import javax.swing.JFileChooser;
//import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileDivider {
	/**
	 * This program is designed to split a file into five pieces.
	 * To do this, it needs to choose a file, split it into five
	 * pieces, and then save each piece as a new file. 
	 */

	JFileChooser chooser = new JFileChooser();
	File target;
	String filePath;
	private static final int TARGET_FILE_COUNT = 5;
	private static final int MAX_BYTES = 120000000;


	public File openFile() {
		/**
		 * This method uses a JFileChooser to let the user select
		 * a file to split.
		 */
		chooser.setDialogTitle("Pick a file to divide.");
		boolean foundGoodFile = false;
		while (!foundGoodFile) {
			int rVal = chooser.showOpenDialog(chooser);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				target = chooser.getSelectedFile();
				if (target.canRead()) {
					foundGoodFile = true;
					filePath = chooser.getSelectedFile().getPath();
					System.out.println(filePath);
				}
			}
			if (rVal == JFileChooser.CANCEL_OPTION) {
				System.out.println("Operation cancelled.");
				System.exit(0);
			}
		}
		return target;

	}

	public String[] divideFile(File base) throws IOException {
		/**
		 * This method divides a file into the target number
		 * of strings, to later be printed again.
		 */
		//String fullFile = "";
		char[] charFile = new char[MAX_BYTES];
		String[] sections = new String[TARGET_FILE_COUNT];
		//read the whole file
		//Scanner in = null;
		FileInputStream in2 = null;
		try {
			//in = new Scanner(base);
			in2 = new FileInputStream(base);
			/*
			if (in.hasNextLine()) {
				fullFile = in.nextLine();
				
				System.out.println("Read first line");
			}
			while (in.hasNextLine()) {
				fullFile = fullFile + "\n" + in.nextLine();
				System.out.println("Read a line");
			}
			//*/
			int r;
			System.out.println("Started reading.");

			for (int i = 0; (r = in2.read()) != -1; i++) {
				charFile[i] = (char) r;
			}
		} finally {
			if (in2 != null) {
				//in.close();
				in2.close();
				System.out.println("Done reading.");
			}
		}
		//do the math and divide the file
		String stringFile = String.valueOf(charFile).trim();
		int minStringSize = stringFile.length() / TARGET_FILE_COUNT;
		
		//int minSize = charFile.length / TARGET_FILE_COUNT;
		//int leftovers = fullFile.length() % TARGET_FILE_COUNT;
		for (int i = 0; i < TARGET_FILE_COUNT; i++) {
			if (i == TARGET_FILE_COUNT - 1) {
				sections[i] = stringFile.substring(i * minStringSize);
			} else {
				sections[i] = stringFile.substring(i * minStringSize, (i + 1) * minStringSize);
			}
		}
		System.out.println("Done dividing.");
		return sections;
	}

	public void saveSections(String[] sections) throws IOException {
		String filetype = filePath.substring(filePath.lastIndexOf('.'));
		String filename = filePath.substring(0, filePath.lastIndexOf('.'));
		for (int i = 0; i < TARGET_FILE_COUNT; i++) {
			FileWriter out = null;
			try {
				out = new FileWriter(String.format(filename + (i + 1) + filetype));
				out.write(sections[i]);
				System.out.println((i + 1) + " of " +TARGET_FILE_COUNT + " files saved.");

			} catch (FileNotFoundException e) {
				System.out.println("File not found exception.");
			} finally {
				if (out != null) {
					out.close();
				}
			}
		}
	}
}
