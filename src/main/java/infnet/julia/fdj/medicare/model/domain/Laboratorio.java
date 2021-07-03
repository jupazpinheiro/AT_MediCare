package infnet.julia.fdj.medicare.model.domain;

import infnet.julia.fdj.medicare.model.exceptions.LaboratorioNaoPreenchidoException;

public class Laboratorio extends Exame {
	
	private int hematologia;
	private int microbiologia;
	private boolean complementar;
	

	public Laboratorio(String descricao, String responsavel, boolean cobertura, float custos) {
		super(descricao, responsavel, cobertura, custos);
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()); //mãe
		sb.append(";");
		sb.append(this.hematologia); //filha
		sb.append(";");
		sb.append(this.microbiologia); //filha
		sb.append(";");
		sb.append(this.complementar ? "Sim" : "Não"); //filha

		
		return sb.toString();
	}



	@Override
	public float calcularCustos() throws LaboratorioNaoPreenchidoException {
		if (this.hematologia < 0 | this.microbiologia < 0) {
			throw new LaboratorioNaoPreenchidoException ("Informe um valor de exames válido!");
		}
		float examesTotais = 0;
		if (!this.isCobertura()) {
			examesTotais = (((this.hematologia + this.microbiologia)*2)+this.getCustos());
		}
		return this.getCustos() + examesTotais;
		}



	public int getHematologia() {
		return hematologia;
	}



	public void setHematologia(int hematologia) {
		this.hematologia = hematologia;
	}



	public int getMicrobiologia() {
		return microbiologia;
	}



	public void setMicrobiologia(int microbiologia) {
		this.microbiologia = microbiologia;
	}



	public boolean isComplementar() {
		return complementar;
	}



	public void setComplementar(boolean complementar) {
		this.complementar = complementar;
	}


	
}
