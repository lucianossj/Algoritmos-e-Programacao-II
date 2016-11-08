package colaboradores;

public class Colaborador {

	private String projeto;
	private String funcionario;
	private String competencia;
	
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	@Override
	public String toString() {
		
		return projeto +" | "+ funcionario +" | "+ competencia;
		
	}
	
	
	
}
