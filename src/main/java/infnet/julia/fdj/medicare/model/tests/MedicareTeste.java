package infnet.julia.fdj.medicare.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.io.ClassPathResource;

import infnet.julia.fdj.medicare.model.domain.Clinico;
import infnet.julia.fdj.medicare.model.domain.Laboratorio;
import infnet.julia.fdj.medicare.model.domain.Consulta;
import infnet.julia.fdj.medicare.model.domain.Imagem;
import infnet.julia.fdj.medicare.model.domain.Medico;
import infnet.julia.fdj.medicare.model.exceptions.ClinicoSemDiagnosticoException;
import infnet.julia.fdj.medicare.model.exceptions.ImagemSemCoberturaException;
import infnet.julia.fdj.medicare.model.exceptions.LaboratorioNaoPreenchidoException;

public class MedicareTeste {
	public static void main (String[]args) {
		try {
			String dir = System.getProperty("user.dir");
			String arq = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMdd"))+".txt";

			
			try {
				InputStream resource = new ClassPathResource("static/consultas.txt").getInputStream();

				FileWriter fileW = new FileWriter(dir + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				BufferedReader leitura = new BufferedReader(new InputStreamReader(resource));

				String linha = leitura.readLine();

				while (linha != null) {

					String[] campos = linha.split(";");
					
						switch (campos[0].toUpperCase()) {
						case "0":
							Medico medico1=new Medico(campos[3], campos[4], Integer.valueOf(campos[5]));
							Consulta c1 = new Consulta();
							c1.setDescricao(campos[1]);
							c1.setUrgente("S".equalsIgnoreCase(campos[2]));
							c1.setMedico(medico1);
							escrita.write(c1.totalExames()+"\r\n");
							break;
						case "1":
							escrita.write("--------------------------------");
							escrita.write("\r\n");
							break;
						case "L":
							Laboratorio l1 = new Laboratorio(campos[1], campos[2], "S".equalsIgnoreCase(campos[3]), Float.valueOf(campos[4]));
							l1.setHematologia(Integer.valueOf(campos[5]));
							l1.setMicrobiologia(Integer.valueOf(campos[6]));
							l1.setComplementar("S".equalsIgnoreCase(campos[7]));
							escrita.write(l1.totalExames());

							
							break;
						case "C":
							Clinico c2 = new Clinico(campos[1], campos[2], "S".equalsIgnoreCase(campos[3]),Float.valueOf(campos[4]));
							c2.setDiagnostico(campos[5]);
							c2.setTipo(campos[6]);
							c2.setSetor(campos[7]);
							escrita.write(c2.totalExames());

							break;
						case "I":
							Imagem i1 = new Imagem(campos[1], campos[2], "S".equalsIgnoreCase(campos[3]),Float.valueOf(campos[4]));
							i1.setArea(Integer.valueOf(campos[5]));
							i1.setRegiao(campos[6]);
							i1.setComplementar("S".equalsIgnoreCase(campos[7]));
							escrita.write(i1.totalExames());

							break;


						default:
							System.out.println("Algo deu Errado");
							break;
						}

					linha = leitura.readLine();
				}
				
				leitura.close();
				escrita.close();
				fileW.close();
			}catch (ClinicoSemDiagnosticoException | ImagemSemCoberturaException | LaboratorioNaoPreenchidoException | IOException e) {
				System.out.println(e.getMessage());
			}
			
		} finally {
		System.out.println("Fim");
		}		
	}
}
