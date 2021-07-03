package infnet.julia.fdj.medicare.model.domain;

import infnet.julia.fdj.medicare.model.exceptions.ImagemSemCoberturaException;

public class Imagem extends Exame {
	
	private int area;
	private boolean complementar;
	private String regiao;
	
	public Imagem(String descricao, String responsavel, boolean cobertura, float custos) {
		super(descricao, responsavel, cobertura, custos);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()); //mãe
		sb.append(";");
		sb.append(this.area); //filha
		sb.append(";");
		sb.append(this.complementar  ? "Sim" : "Não"); //filha
		sb.append(";");
		sb.append(this.regiao); //filha
		
		
		return sb.toString();
	}


	@Override
	public float calcularCustos() throws ImagemSemCoberturaException {
		if (this.regiao.isBlank()) {
			throw new ImagemSemCoberturaException("Necessário informar a região do exame.");
		}
		float examesTotais = 0;
		if (!this.isCobertura() && !this.isComplementar()) {
			examesTotais = ((this.area *5)+this.getCustos());
		}
		if (!this.isCobertura() && this.isComplementar()) {
			examesTotais = ((this.area *3)+this.getCustos());
		}
		if (this.isCobertura() && !this.isComplementar()) {
			examesTotais = ((this.area *7)+this.getCustos());
		}
		return this.getCustos() + examesTotais;
	}

	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}

	public boolean isComplementar() {
		return complementar;
	}

	public void setComplementar(boolean complementar) {
		this.complementar = complementar;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	

}
