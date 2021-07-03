package infnet.julia.fdj.medicare.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
	private String descricao;
	private boolean urgente;
	private LocalDateTime data;
	private Medico medico;
	
	public Consulta() {
		data = LocalDateTime.now();
	}
	
	
	public Consulta(String descricao, boolean urgente) {
		this();
		this.descricao = descricao;
		this.urgente = urgente;
	}
	
	public String totalExames() {
		return String.format("Exames solicidados por Dr(a) %s.", 
					this.medico.getNome()
				);
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dataconsulta = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return String.format("%s; %b; %s;%s", 
				this.descricao , this.urgente, this.data.format(dataconsulta),
				this.medico); //int=%d, float=%.2f
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isUrgente() {
		return urgente;
	}

	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}

	public LocalDateTime getData() {
		return data;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	
	
}
