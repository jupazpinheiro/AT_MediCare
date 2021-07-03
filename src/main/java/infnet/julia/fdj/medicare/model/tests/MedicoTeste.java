package infnet.julia.fdj.medicare.model.tests;

import infnet.julia.fdj.medicare.model.domain.Medico;
public class MedicoTeste {
	public static void main(String[] args) {
		Medico m1= new Medico("Dr Julia" , "99999999" , 24193);
		System.out.println("Médico responsável: " + m1);
		
	}
}
