package infnet.julia.fdj.medicare.model.domain;

import infnet.julia.fdj.medicare.model.exceptions.ClinicoSemDiagnosticoException;
  

public class Clinico extends Exame {
	
	private String diagnostico;
	private String tipo;
	private String setor;
	

	public Clinico(String descricao, String responsavel, boolean cobertura, float custos) {
		super(descricao, responsavel, cobertura, custos);
		
	}
	@Override
	public String toString() {
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()); //mãe
		sb.append(";");
		sb.append(this.diagnostico); //filha
		sb.append(";");
		sb.append(this.tipo); //filha
		sb.append(";");
		sb.append(this.setor); //filha

		
		return sb.toString();
	}

	@Override
	public float calcularCustos() throws ClinicoSemDiagnosticoException {
		if (this.diagnostico.isBlank()) {
			throw new ClinicoSemDiagnosticoException ("Necessário diagnóstico ou pré diagnóstico para requerer exames.");
		}
		return this.getCustos() +250;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}




}
