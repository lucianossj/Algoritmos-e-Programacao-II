package funcionarios;

import java.util.Arrays;

public class Funcionario {

	private String 		nome;
	private double 		salario;
	private int			numeroCompetencias;
	private String[] 	competencia;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getNumeroCompetencias() {
		return numeroCompetencias;
	}
	public void setNumeroCompetencias(int numeroCompetencias) {
		this.numeroCompetencias = numeroCompetencias;
	}
	public String[] getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String[] competencias) {
		this.competencia = competencias;
	}
	@Override
	public String toString() {
		return nome +" | "+ salario +" | "+ numeroCompetencias +" | "+ Arrays.toString(competencia);
	}
	
	
}
