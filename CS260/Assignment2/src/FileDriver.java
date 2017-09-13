import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDriver {
	/**
	 * This class initializes and manages the operation of the FileDivider class.
	 */

	public static void main(String[] args) throws IOException, FileNotFoundException {
		FileDivider fd = new FileDivider();
		fd.saveSections( fd.divideFile( fd.openFile() ) );
	}
}
