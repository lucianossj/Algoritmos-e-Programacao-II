package principal;

import funcionarios.Funcionario;

public class VetorFuncionario<Funcionario> {
	
	int numeroElementos = 0;

	@SuppressWarnings("unchecked")
	Funcionario[] dados = (Funcionario[])new Object[2];
	
	public void append(Funcionario valor) {	
		garantirEspaco();
		// Inserir no fim dos elementos
		dados[numeroElementos] = valor;

		// Incrementar elementos
		numeroElementos++;
	}

	public int getSize() {
		return numeroElementos;
	}

	public void validaIndice(int index) {
		if (index < 0 || index >= numeroElementos)
			throw new ArrayIndexOutOfBoundsException(index);
	}

	public void insert(int index, Funcionario valor) {
		validaIndice(index);
		garantirEspaco();
		for (int i = numeroElementos; i > index; i--) {
			dados[i] = dados[i-1];
		}
		dados[index] = valor;
		numeroElementos++;
	}
	
	private void garantirEspaco() {
		if (numeroElementos >= dados.length) {
			
			@SuppressWarnings("unchecked")
			
			Funcionario[] novosDados = (Funcionario[])new Object[numeroElementos * 2];

			for (int contador = 0; contador < numeroElementos; contador++) {
				novosDados[contador] = this.dados[contador];
			}
			this.dados = novosDados;
		}
	}
	
	public void remove(int index){
		validaIndice(index);
		numeroElementos--;	
		for(int i = index; index < numeroElementos-1; i++){
			dados[i] = dados[i+1];
		}
		
	}

	public Funcionario get(int index) {
		validaIndice(index);
		return dados[index];
	}
	
}
