package infnet.julia.fdj.medicare.model.domain;

import infnet.julia.fdj.medicare.model.exceptions.ClinicoSemDiagnosticoException;
import infnet.julia.fdj.medicare.model.exceptions.ImagemSemCoberturaException;
import infnet.julia.fdj.medicare.model.exceptions.LaboratorioNaoPreenchidoException;

public abstract class Exame {
	private String descricao;
	private String responsavel;
	private boolean cobertura;
	private float custos;
	
	public Exame (String descricao, String responsavel, 
			boolean cobertura ,float custos) {
		this.descricao = descricao;
		this.responsavel = responsavel;
		this.cobertura = cobertura;
		this.custos = custos;
	}
	
	public String totalExames() throws LaboratorioNaoPreenchidoException, ImagemSemCoberturaException, ClinicoSemDiagnosticoException {
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.responsavel);
		sb.append(";");
		sb.append(this.cobertura);
		sb.append(";");
		sb.append(this.custos);
		sb.append(";");
		sb.append(this.calcularCustos());
		sb.append("\r\n");
		
		return sb.toString();
	}
			
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.responsavel);
		sb.append(";");
		sb.append(this.cobertura);
		sb.append(";");
		sb.append(this.custos);
		
		return sb.toString();
	}



	public abstract float calcularCustos() throws LaboratorioNaoPreenchidoException, ImagemSemCoberturaException, ClinicoSemDiagnosticoException; 
	
	//apenas método get
	public String getDescricao() {
		return descricao;
	}

	public float getCustos() {
		
		return custos;
	}

	public String getResponsavel() {

		return this.responsavel;
	}


	public boolean isCobertura() {
		
		return cobertura;
	}

	
}
