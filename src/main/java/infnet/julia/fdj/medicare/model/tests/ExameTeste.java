package infnet.julia.fdj.medicare.model.tests;

import infnet.julia.fdj.medicare.model.domain.Clinico;
import infnet.julia.fdj.medicare.model.domain.Imagem;
import infnet.julia.fdj.medicare.model.domain.Laboratorio;
import infnet.julia.fdj.medicare.model.exceptions.ClinicoSemDiagnosticoException;
import infnet.julia.fdj.medicare.model.exceptions.ImagemSemCoberturaException;
import infnet.julia.fdj.medicare.model.exceptions.LaboratorioNaoPreenchidoException;

public class ExameTeste {
	public static void main(String[] args) {
		
		try {
			Laboratorio l1 = new Laboratorio("valor especial", "Dra Julia", false, 20);
			l1.setHematologia(2);
			l1.setMicrobiologia(-4);
			l1.setComplementar(true);
			System.out.printf("Laboratório >>>>%s ", l1.totalExames());}
		catch (ClinicoSemDiagnosticoException | ImagemSemCoberturaException | LaboratorioNaoPreenchidoException e) {
			System.out.println(e.getMessage());}	
		try {
			Laboratorio l1 = new Laboratorio("valor especial", "Dra Julia", false, 20);
			l1.setHematologia(2);
			l1.setMicrobiologia(4);
			l1.setComplementar(true);
			System.out.printf("Laboratório >>>>%s ", l1.totalExames());}
		catch (ClinicoSemDiagnosticoException | ImagemSemCoberturaException | LaboratorioNaoPreenchidoException e) {
			System.out.println(e.getMessage());}	
		try {
			Laboratorio l1 = new Laboratorio("valor especial", "Dra Julia", false, 20);
			l1.setHematologia(-2);
			l1.setMicrobiologia(4);
			l1.setComplementar(true);
			System.out.printf("Laboratório >>>>%s ", l1.totalExames());}
		catch (ClinicoSemDiagnosticoException | ImagemSemCoberturaException | LaboratorioNaoPreenchidoException e) {
			System.out.println(e.getMessage());}	
		try {
			Imagem i1 = new Imagem("final", "Dr Elberth", false, 20);
			i1.setArea(3);
			i1.setRegiao("Torax");
			i1.setComplementar(false);
			System.out.printf("Imagem >>>>>%s ", i1.totalExames());}
		catch (ClinicoSemDiagnosticoException | ImagemSemCoberturaException | LaboratorioNaoPreenchidoException e) {
			System.out.println(e.getMessage());}	
		try {
			Imagem i1 = new Imagem("final", "Dr Elberth", false, 20);
			i1.setArea(3);
			i1.setRegiao(" ");
			i1.setComplementar(false);
			System.out.printf("Imagem >>>>>%s ", i1.totalExames());}
		catch (ClinicoSemDiagnosticoException | ImagemSemCoberturaException | LaboratorioNaoPreenchidoException e) {
			System.out.println(e.getMessage());}
		try {
			Clinico c1 = new Clinico("viagem", "Dr Rodrigo", false, 20);
			c1.setDiagnostico(" ");
			c1.setTipo("Tratamento");
			c1.setTipo("Pediatria");
			System.out.printf("Clínico >>>>>>%s ", c1.totalExames());}
		catch (ClinicoSemDiagnosticoException | ImagemSemCoberturaException | LaboratorioNaoPreenchidoException e) {
			System.out.println(e.getMessage());}
		try {
			Clinico c1 = new Clinico("viagem", "Dr Rodrigo", false, 20);
			c1.setDiagnostico("Gripe comum");
			c1.setTipo("Tratamento");
			System.out.printf("Clínico >>>>>>%s ", c1.totalExames());}
		catch (ClinicoSemDiagnosticoException | ImagemSemCoberturaException | LaboratorioNaoPreenchidoException e) {
			System.out.println(e.getMessage());}
		
	}
}
