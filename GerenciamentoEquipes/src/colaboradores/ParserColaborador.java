package colaboradores;

import java.util.Scanner;

import principal.Parser;

public class ParserColaborador implements Parser<Colaborador>{

	@Override
	public Colaborador parseObject(String dadosCSV) {
		
		Scanner parser = new Scanner(dadosCSV);
		parser.useDelimiter(";");
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setProjeto		(parser.next());
		colaborador.setFuncionario	(parser.next());
		colaborador.setCompetencia	(parser.next());
		
		parser.close();
		
		return colaborador;
		
	}
	
}
