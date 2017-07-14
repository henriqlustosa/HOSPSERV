package hspm.centrocirurgico.modelorelatorio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hspm.util.ConexaoOpenbase;
import hspm.util.FormataDataHora;

public class ModeloRelatorio2DAOOpenbase {
	public List<ModeloRelatorio2> relatorioNumero9(Integer ano) {
		String[] salas = { "701", "702", "703", "704", "705", "706", "707", "708", "709", "710" };

		return montarRelatorios(ano, salas);
	}

	public List<ModeloRelatorio2> relatorioNumero10(Integer ano) {

		String[] salas = { "801", "802", "803", "804" };

		return montarRelatorios(ano, salas);
	}

	public List<ModeloRelatorio2> montarRelatorios(Integer ano, String[] salas) {

		String sql = "select  c38hinianest,c38hentrec, c38flagemerg  from cir38 where c38codsala = ? and  d38dataexec >= ? and d38dataexec <= ? ";
		String dtInicio = ano.toString() + "0101";
		String dtFim = ano.toString() + "1231";
		List<ModeloRelatorio2> lista = new ArrayList<ModeloRelatorio2>();

	

		ModeloRelatorio2 p;
		ModeloRelatorio2 pTotal;
		pTotal = new ModeloRelatorio2();
		pTotal.setNomeSala("TOTAL GERAL");

		for (String sala : salas) {
			p = new ModeloRelatorio2();
			p.setNomeSala(sala);

			Connection conn1 = new ConexaoOpenbase().getConnection();
			ResultSet rs1 = null;
			PreparedStatement stmt1 = null;
			try {

				stmt1 = conn1.prepareStatement(sql);
				stmt1.setString(1, sala);
				stmt1.setString(2, dtInicio);
				stmt1.setString(3, dtFim);
				rs1 = stmt1.executeQuery();
				while (rs1 != null && rs1.next()) {
					String flagEmerg = rs1.getString("c38flagemerg");
					if (flagEmerg.equals("S")){
						p.setOcupUrgencia(FormataDataHora.calculaSomaTEmpo(p.getOcupUrgencia(),
								FormataDataHora.calculaDiffHora(
										FormataDataHora.formataHora(rs1.getString("c38hinianest")),
										FormataDataHora.formataHora(rs1.getString("c38hentrec")))));
						p.setProcUrgencia(1);

					} else {
						
						p.setOcupEletivos(FormataDataHora.calculaSomaTEmpo(p.getOcupEletivos(),
								FormataDataHora.calculaDiffHora(
										FormataDataHora.formataHora(rs1.getString("c38hinianest")),
										FormataDataHora.formataHora(rs1.getString("c38hentrec")))));
						p.setProcEletivos(1);

					}

				}

				pTotal.setProcEletivos(p.getProcEletivos());
				pTotal.setProcUrgencia(p.getProcUrgencia());

				pTotal.setOcupEletivos(FormataDataHora.calculaSomaTEmpo(p.getOcupEletivos(), pTotal.getOcupEletivos()));
				pTotal.setOcupUrgencia(FormataDataHora.calculaSomaTEmpo(p.getOcupUrgencia(), pTotal.getOcupUrgencia()));

				p.setOcupTotal(FormataDataHora.calculaSomaTEmpo(p.getOcupEletivos(), p.getOcupUrgencia()));
				p.setProcTotal(p.getProcEletivos() + p.getProcUrgencia());

				pTotal.setProcTotal(p.getProcTotal());
				pTotal.setOcupTotal(FormataDataHora.calculaSomaTEmpo(p.getOcupTotal(), pTotal.getOcupTotal()));
				lista.add(p);
				//p = null;

			} catch (Exception e) {
				System.out.println("Erro ao listar o relatório.Mensagemmm: " + e.getMessage());
			} finally {
				try {
					stmt1.close();
					conn1.close();
				} catch (Throwable ex) {
					System.out.println("Erro ao fechar operaçõe de busca neste relatório. Mensagem: " + ex.getMessage());
				}
			}
		}
		lista.add(pTotal);
		pTotal = null;
		return lista;

	}

}
