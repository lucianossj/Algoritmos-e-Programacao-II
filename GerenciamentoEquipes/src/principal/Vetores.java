package principal;

import funcionarios.Funcionario;
import projetos.Projeto;

public class Vetores {
	
	int indFunc = 1;
	int indProj = 1;
	
	public Funcionario[] 	funcionarios 	= new Funcionario[indFunc];
	public Projeto[] 		projetos 		= new Projeto[indProj];
	
	public Funcionario[] aumentaVetorFuncionarios(Funcionario[] funcionarios){
		
		Funcionario[] funcionariosNovo = new Funcionario[indFunc];
		
		for(int i = 0; i < funcionarios.length; i++){
			
			funcionariosNovo[i] = funcionarios[i];
			
		}
		
		indFunc = indFunc + 1;
		
		funcionarios = new Funcionario[indFunc];
		funcionarios = funcionariosNovo;
		
		return funcionarios;
		
	}
	
	public Projeto[] aumentaVetorProjetos(Projeto[] projetos){
		
		Projeto[] projetosNovo = new Projeto[indFunc];
		
		for(int i = 0; i < projetos.length; i++){
			
			projetosNovo[i] = projetos[i];
			
		}
		
		indFunc = indFunc + 1;
		
		projetos = new Projeto[indFunc];
		projetos = projetosNovo;
		
		return projetos;
		
	}
	
}
