
public class FileInvalidException extends Exception {

	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information.");
	}

	public FileInvalidException(String message) {
		System.out.println(message);
	}

}
