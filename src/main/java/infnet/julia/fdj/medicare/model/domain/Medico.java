package infnet.julia.fdj.medicare.model.domain;

public class Medico {
	private String nome;
	private String telefone;
	private int crm;
	
	public Medico (String nome, String telefone, int crm) {
		this.nome = nome;
		this.telefone = telefone;
		this.crm = crm;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.telefone);
		sb.append(";");
		sb.append(this.crm);
		
		return sb.toString();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}



	
}
