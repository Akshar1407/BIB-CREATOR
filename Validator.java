
public class Validator {

	public static String removeFromRear(String input, int size, String remove) {

		if (input != null && input.length() > 0) {
			int length = input.length();

			StringBuffer buf = new StringBuffer(input);

			buf.replace(0, remove.length(), "");
			length = buf.length();
			int start = length - size;
			int end = length;
			buf.replace(start, end, "");
			return buf.toString();
		} else {
			return "";
		}

	}
}
