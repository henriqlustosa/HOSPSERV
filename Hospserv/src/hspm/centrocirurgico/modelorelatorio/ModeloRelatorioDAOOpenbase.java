package hspm.centrocirurgico.modelorelatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hspm.util.ConexaoOpenbase;
import hspm.util.FormataDataHora;

public class ModeloRelatorioDAOOpenbase {
	public List<ModeloRelatorio> relatorioNumero5(Integer ano) {
		String dtInicio = "";
		String dtFim = "";

		List<ModeloRelatorio> lista = new ArrayList<ModeloRelatorio>();

		String[][] horario = { { "0700", "1859", "DIA" }, { "1900", "2359", "NOITE" }, { "0000", "0659", "MANHA" },
				{ "0000", "2359", "TOTAL" } };
		String[][] meses = { { "01", "JAN" }, { "02", "FEV" }, { "03", "MAR" }, { "04", "ABR" }, { "05", "MAI" },
				{ "06", "JUN" }, { "07", "JUL" }, { "08", "AGO" }, { "09", "SET" }, { "10", "OUT" }, { "11", "NOV" },
				{ "12", "DEZ" } };
		// String sql = "select count(*) as qtd from cir38 where (c38codclin
		// ='518' or c38codclin ='538' or c38codclin ='537' or c38codclin
		// ='575')and c38hfimexec >= ? and c38hfimexec <= ? and d38dataexec >= ?
		// and d38dataexec <= ? ";

		String sql1 = "select c38hiniexec,c38hfimexec from cir38 where (c38codclin ='518' or c38codclin ='538' or c38codclin ='537' or c38codclin ='575')and c38hfimexec >= ? and c38hfimexec <= ? and d38dataexec >= ? and d38dataexec <= ? ";

		ModeloRelatorio p;
		ModeloRelatorio pTotal;
		pTotal = new ModeloRelatorio();
		pTotal.setNomeMes("TOTAL GERAL");

		for (int i = 0; i < meses.length; i++) {
			p = new ModeloRelatorio();
			p.setNomeMes(meses[i][1]);

			for (int j = 0; j < horario.length; j++) {

				Connection conn1 = new ConexaoOpenbase().getConnection();
				ResultSet rs1 = null;
				PreparedStatement stmt1 = null;
				try {

					dtInicio = ano.toString() + meses[i][0] + "01";
					dtFim = ano.toString() + meses[i][0] + "31";

					stmt1 = conn1.prepareStatement(sql1);
					stmt1.setString(1, horario[j][0]);
					stmt1.setString(2, horario[j][1]);
					stmt1.setString(3, dtInicio);
					stmt1.setString(4, dtFim);
					rs1 = stmt1.executeQuery();
					while (rs1.next()) {
						if (horario[j][2] == "DIA") {
							p.setTempoMesProcDia(FormataDataHora.calculaSomaTEmpo(p.getTempoMesProcDia(),
									FormataDataHora.calculaDiffHora(
											FormataDataHora.formataHora(rs1.getString("c38hiniexec")),
											FormataDataHora.formataHora(rs1.getString("c38hfimexec")))));
							p.setQtdMesProcDia(1);

						} else if (horario[j][2] == "NOITE") {
							p.setTempolMesProcNoite(FormataDataHora.calculaSomaTEmpo(p.getTempolMesProcNoite(),
									FormataDataHora.calculaDiffHora(
											FormataDataHora.formataHora(rs1.getString("c38hiniexec")),
											FormataDataHora.formataHora(rs1.getString("c38hfimexec")))));
							p.setQtdMesProcNoite(1);

						} else if (horario[j][2] == "MANHA") {
							p.setTempoMesProcManha(FormataDataHora.calculaSomaTEmpo(p.getTempoMesProcManha(),
									FormataDataHora.calculaDiffHora(
											FormataDataHora.formataHora(rs1.getString("c38hiniexec")),
											FormataDataHora.formataHora(rs1.getString("c38hfimexec")))));
							p.setQtdMesProcManha(1);

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
			pTotal.setQtdMesProcDia(p.getQtdMesProcDia());
			pTotal.setQtdMesProcNoite(p.getQtdMesProcNoite());
			pTotal.setQtdMesProcManha(p.getQtdMesProcManha());

			pTotal.setTempoMesProcDia(
					FormataDataHora.calculaSomaTEmpo(p.getTempoMesProcDia(), pTotal.getTempoMesProcDia()));
			pTotal.setTempolMesProcNoite(
					FormataDataHora.calculaSomaTEmpo(p.getTempolMesProcNoite(), pTotal.getTempolMesProcNoite()));
			pTotal.setTempoMesProcManha(
					FormataDataHora.calculaSomaTEmpo(p.getTempoMesProcManha(), pTotal.getTempoMesProcManha()));

			p.setTempoMesProcTotalLinha(FormataDataHora.calculaSomaTEmpo(p.getTempoMesProcDia(),
					FormataDataHora.calculaSomaTEmpo(p.getTempolMesProcNoite(), p.getTempoMesProcManha())));
			p.setQtdMesProcTotalLinha(p.getQtdMesProcDia() + p.getQtdMesProcNoite() + p.getQtdMesProcManha());

			pTotal.setQtdMesProcTotalLinha(p.getQtdMesProcTotalLinha());
			pTotal.setTempoMesProcTotalLinha(FormataDataHora.calculaSomaTEmpo(p.getTempoMesProcTotalLinha(),
					pTotal.getTempoMesProcTotalLinha()));
			lista.add(p);
			p = null;

		}
		lista.add(pTotal);
		pTotal = null;
		return lista;
	}

}
