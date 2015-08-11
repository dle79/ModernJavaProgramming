package lesson10.lab10.prob3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class NewFileIO {
	public final static String FILE_LOCATION = "src/lesson10/lab10/prob3/word_test.txt";

	void readText(String filename) throws IOException {
		File f = new File(filename);
		Files.lines(f.toPath()).map(s -> s.trim()).filter(s -> !s.isEmpty())
				.forEach(System.out::println);

	}

	public static void main(String[] args) {
		NewFileIO newFileIO = new NewFileIO();
		String filename = FILE_LOCATION;
		try {
			newFileIO.readText(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
