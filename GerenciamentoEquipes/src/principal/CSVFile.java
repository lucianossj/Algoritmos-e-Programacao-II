package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CSVFile<T> {
	private Scanner arquivo;
	private Parser<T> parser;
	
	public CSVFile(String filename, Parser<T> parser)
			throws FileNotFoundException
	{
		this.arquivo = new Scanner(
				new BufferedReader(
					new FileReader(filename)
				)
			);
		this.parser = parser;
	}
	
	public T readObject() {
		if (arquivo.hasNext())
			return parser.parseObject(arquivo.nextLine());
		return null;
	}
	
	public void skipLine() {
		if (arquivo.hasNext())
			arquivo.nextLine();
	}
}
