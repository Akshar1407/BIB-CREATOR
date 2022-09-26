import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibCreator {

	// For reading inputs from user
	public static Scanner scanner = null;

	static int count = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Article> articleList = new ArrayList<Article>();

		for (int i = 1; i <= 10; i++) {
			//articleList = new ArrayList<Article>();
			try {
				File file = new File("Files/Latex" + i + ".bib");
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				System.out.println("File does not exist, please, check the project location.");
				// System.exit(0);
				continue;
			}

			Article article = new Article();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (line.length() == 0)
					continue;

				if (line.startsWith("@")) {
					System.out.println(count++);
					continue;
				}

				if (line.startsWith("}")) {
//					//count++;
					articleList.add(article);
					article = new Article();
					continue;
				}

				//System.out.println(line);

				if (line.startsWith("author")) {
					article.setAuthor(Validator.removeFromRear(line, 2, "author={"));
					continue;
				} else if (line.startsWith("journal")) {
					article.setJournal(Validator.removeFromRear(line, 2, "journal={"));
					continue;
				} else if (line.startsWith("title")) {
					article.setTitle(Validator.removeFromRear(line, 2, "title={"));
					continue;
				} else if (line.startsWith("year")) {
					article.setYear(Integer.parseInt(Validator.removeFromRear(line, 2, "year={")));
					continue;
				} else if (line.startsWith("volume")) {
					article.setVolume(Validator.removeFromRear(line, 2, "volume={"));
					continue;
				} else if (line.startsWith("number")) {
					System.out.println(line);
					String value = Validator.removeFromRear(line, 2, "number={");
					if(value.length() > 0) {
						article.setNumber(Integer.parseInt(value));	
					} else {
						// break;
					}
					continue;
				} else if (line.startsWith("pages")) {
					article.setPages(Validator.removeFromRear(line, 2, "pages={"));
					continue;
				} else if (line.startsWith("keywords")) {
					article.setKeywords(Validator.removeFromRear(line, 2, "keywords={"));
					continue;
				} else if (line.startsWith("doi")) {
					article.setDoi(Validator.removeFromRear(line, 2, "doi={"));
					continue;
				} else if (line.startsWith("ISSN")) {
					article.setISSN(Validator.removeFromRear(line, 2, "ISSN={"));
					continue;
				} else if (line.startsWith("month")) {
					article.setMonth(Validator.removeFromRear(line, 2, "month={"));
					continue;
				} else if (!line.startsWith("jou")) {

					article.setId(Long.parseLong(Validator.removeFromRear(line, 1, "")));

					continue;
				}
			}

		}

		for (Article article : articleList) {
			System.out.println(article);
		}

		System.exit(0);
		scanner.close();

	}

}
