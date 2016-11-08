package funcionarios;

import java.util.Locale;
import java.util.Scanner;
import principal.Parser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParserFuncionario implements Parser<Funcionario>{

	@Override
	public Funcionario parseObject(String dadosCSV) {
		
		Scanner parser = new Scanner(dadosCSV);
		parser.useDelimiter(";");
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(parser.next());
		
		String salario = parser.next();
		funcionario.setSalario(Double.parseDouble(salario));
		funcionario.setNumeroCompetencias(parser.nextInt());
		
		String[] competencias = new String[funcionario.getNumeroCompetencias()];
		for(int i = 0; i < funcionario.getNumeroCompetencias(); i++){
			
			competencias[i] = parser.next();
			
		}
		
		funcionario.setCompetencia(competencias);
		
		parser.close();
		
		return funcionario;
		
	}
	
}
