package hspm.centrocirurgico.modelorelatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hspm.util.ConexaoOpenbase;


public class ModeloRelatorioDAOOpenbase {
	public List<ModeloRelatorio> relatorioNumero5(Integer ano) {
		String dtInicio = "";
		String dtFim = "";
		

		List<ModeloRelatorio> lista = new ArrayList<ModeloRelatorio>();
		
		String[][] horario = { { "0700", "1859", "DIA" }, { "1900", "2359", "NOITE" }, { "0000", "0659", "MANHA" }, { "0000", "2359", "TOTAL" }  };
		String[][] meses = { { "01", "JAN" }, { "02", "FEV" }, { "03", "MAR" }, { "04", "ABR" }, { "05", "MAI" },
				{ "06", "JUN" }, { "07", "JUL" }, { "08", "AGO" }, { "09", "SET" }, { "10", "OUT" }, { "11", "NOV" },
				{ "12", "DEZ" },{ "13", "TOTAL" } };
		String sql = "select count(*) as qtd from cir38 where (c38codclin ='518' or c38codclin ='538' or c38codclin ='537' or c38codclin ='575')and c38hfimexec >= ? and c38hfimexec <= ? and d38dataexec >= ? and d38dataexec <= ? ";
		
		ModeloRelatorio p;
	
		
		
		for (int i = 0; i < meses.length; i++) {

			p = new ModeloRelatorio();
			p.setNomeMes(meses[i][1]);
			

			for (int j = 0; j < horario.length; j++) {

				Connection conn1 = new ConexaoOpenbase().getConnection();
				ResultSet rs1 = null;
				PreparedStatement stmt1 = null;
				try {
					if (meses[i][1] == "TOTAL") {
						dtInicio = ano.toString() + "01" + "01";
						dtFim = ano.toString() + "12" + "31";
					} else {
						dtInicio = ano.toString() + meses[i][0] + "01";
						dtFim = ano.toString() + meses[i][0] + "31";
					}

					stmt1 = conn1.prepareStatement(sql);
					stmt1.setString(1, horario[j][0]);
					stmt1.setString(2, horario[j][1]);
					stmt1.setString(3, dtInicio);
					stmt1.setString(4, dtFim);
					rs1 = stmt1.executeQuery();
					if (rs1.next()) {
						if (horario[j][2] == "DIA") {
							p.setQtdMesProcDia(rs1.getInt("qtd"));
							
							
						} else if (horario[j][2] == "NOITE") {
							p.setQtdMesProcNoite(rs1.getInt("qtd"));
						
							
						} else if (horario[j][2] == "MANHA") {
							p.setQtdMesProcManha(rs1.getInt("qtd"));
							
							
						}else if (horario[j][2] == "TOTAL") {
						
							p.setQtdMesProcTotalLinha(rs1.getInt("qtd"));
						
						}

					}
				} catch (Exception e) {
					System.out.println("Erro ao listar o relatório. Mensagem: " + e.getMessage());
				} finally {
					try {
						stmt1.close();
						conn1.close();
					} catch (Throwable ex) {
						System.out.println(
								"Erro ao fechar operações de busca neste relatório. Mensagem: " + ex.getMessage());
					}
				}

			}
			lista.add(p);
			p=null;
			
		}
		
		
		return lista;
	}

}
