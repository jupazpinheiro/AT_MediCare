package infnet.julia.fdj.medicare.model.tests;

import infnet.julia.fdj.medicare.model.domain.Consulta;
import infnet.julia.fdj.medicare.model.domain.Medico;
public class ConsultaTeste {
	public static void main(String[] args) {
		
		Medico medico1=new Medico("Dr Pedro", "999-9999", 24892);
		Medico medico2=new Medico("Dra Ana", "999-9999", 25862);
		
		Consulta c1 = new Consulta();
		c1.setDescricao("ConsultaDraJulia");
		c1.setUrgente(true);
		c1.setMedico(medico1);
		System.out.println ("Consulta: "+ c1);
		
		Consulta c2 = new Consulta("Consulta da Dr Elberth", true);
		c2.setDescricao("ConsultaDrElberth");
		c2.setUrgente(false);
		c2.setMedico(medico2);
		System.out.println ("Consulta: "+ c2);
		
	}

}
