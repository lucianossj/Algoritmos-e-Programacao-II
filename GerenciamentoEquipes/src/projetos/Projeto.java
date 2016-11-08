package projetos;

import java.time.LocalDate;
import java.util.Arrays;

public class Projeto {

	private String		nome;
	private LocalDate 	dataInicio;
	private LocalDate 	dataFim;
	private int			numeroCompetencias;
	private String[] 	competencias = new String[numeroCompetencias];
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	public int getNumeroCompetencias() {
		return numeroCompetencias;
	}
	public void setNumeroCompetencias(int numeroCompetencias) {
		this.numeroCompetencias = numeroCompetencias;
	}
	public String[] getCompetencias() {
		return competencias;
	}
	public void setCompetencias(String[] competencias) {
		this.competencias = competencias;
	}
	@Override
	public String toString() {
		
		return nome +" | "+ dataInicio +" | "+ dataFim +" | "+ numeroCompetencias +" | "+ Arrays.toString(competencias);
		
	}
	
}
