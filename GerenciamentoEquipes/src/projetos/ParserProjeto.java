package projetos;

import java.util.Locale;
import java.util.Scanner;
import principal.Parser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParserProjeto implements Parser<Projeto>{

	@Override
	public Projeto parseObject(String dadosCSV) {
		
		Scanner parser = new Scanner(dadosCSV);
		parser.useDelimiter(";");		
		
		LocalDate inicio 	= null;
		LocalDate fim		= null;
		
		Projeto projeto = new Projeto();
		
		projeto	.setNome(parser.next());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale(Locale.US);
		inicio 	= LocalDate.parse(parser.next(), formatter);
		fim 	= LocalDate.parse(parser.next(), formatter);
		
		projeto	.setDataInicio(inicio);
		projeto	.setDataFim(fim);
		
		projeto	.setNumeroCompetencias(parser.nextInt());
		
		String[] competencias = new String[projeto.getNumeroCompetencias()];
		for(int i = 0; i < projeto.getNumeroCompetencias(); i++){
			
			competencias[i] = parser.next();
			
		}
		
		projeto	.setCompetencias(competencias);
		
		parser.close();
		
		return projeto;
		
	}
	
}
