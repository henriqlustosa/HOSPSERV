package hspm.centrocirurgico.cirurgia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hspm.util.ConexaoOpenbase;
import hspm.util.FormataDataHora;

public class CirurgiaDAOOpenbase implements CirurgiaDAO {

	@Override
	public List<Cirurgia> listarPorteGrafico(Integer ano) {

		Connection conn = new ConexaoOpenbase().getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sql = "select count(*) as qtd, c38porte from tsql.cir38 where i38anoref = ? group by c38porte";
		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		Cirurgia p;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ano);
			rs = stmt.executeQuery();
			while (rs.next()) {
				p = new Cirurgia();
				p.setPorte(rs.getString("c38porte"));
				p.setQtdPorte(rs.getInt("qtd"));
				lista.add(p);
				p = null;
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar porte. Mensagem: " + e.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		return lista;
	}

	public List<Cirurgia> listarIniCirMaiorFim(Integer ano) {

		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		Cirurgia e;
		try {
			stmt = conn.prepareStatement(
					"Select i38numseq, i38anoref, i38pront, d38dataexec, c38hiniexec, c38hfimexec, c38codsala, c29nomesala From cir38, cir29 Where c38hiniexec > c38hfimexec And c38codsala = c29codsala And i38anoref = ?");
			stmt.setInt(1, ano);
			rs = stmt.executeQuery();
			while (rs.next()) {
				e = new Cirurgia();
				e.setNumCirurgia(rs.getInt("i38numseq"));
				e.setAnoCirurgia(rs.getInt("i38anoref"));
				e.setProntuario(rs.getInt("i38pront"));
				e.setDtCirurgia(FormataDataHora.formataData(rs.getString("d38dataexec")));
				e.sethInicioCirur(FormataDataHora.formataHora(rs.getString("c38hiniexec")));
				e.setHfimCirur(FormataDataHora.formataHora(rs.getString("c38hfimexec")));
				e.setSalaCirurcica(rs.getString("c38codsala") + " - " + rs.getString("c29nomesala"));

				Integer hi = rs.getInt("c38hiniexec");
				Integer hf = rs.getInt("c38hfimexec");
				Integer tp = hi - hf;

				/*
				 * se o tempo de cirurgia for menor que 40 ou igual adiciona na
				 * lista
				 */
				if (tp <= 40) {
					lista.add(e);
				}
				e = null;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao listar cirurgias. Mensagem: " + ex.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		return lista;
	}

	@Override
	public List<Cirurgia> listarIniAnestMaiorFim(Integer ano) {
		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		Cirurgia e;
		try {
			stmt = conn.prepareStatement(
					"Select i38numseq, i38anoref, i38pront, d38dataexec, c38hinianest, c38hfimanest, c38codsala, c29nomesala From cir38, cir29 Where c38hinianest > c38hfimanest And c38codsala = c29codsala And i38anoref = ?");
			stmt.setInt(1, ano);
			rs = stmt.executeQuery();
			while (rs.next()) {
				e = new Cirurgia();
				e.setNumCirurgia(rs.getInt("i38numseq"));
				e.setAnoCirurgia(rs.getInt("i38anoref"));
				e.setProntuario(rs.getInt("i38pront"));
				e.setDtCirurgia(FormataDataHora.formataData(rs.getString("d38dataexec")));
				e.sethInicioAnest(FormataDataHora.formataHora(rs.getString("c38hinianest")));
				e.sethFimAnest(FormataDataHora.formataHora(rs.getString("c38hfimanest")));
				e.setSalaCirurcica(rs.getString("c38codsala") + " - " + rs.getString("c29nomesala"));

				Integer hi = rs.getInt("c38hinianest");
				Integer hf = rs.getInt("c38hfimanest");
				Integer tp = hi - hf;

				/*
				 * se o tempo de anestesia for menor que 40 ou igual adiciona na
				 * lista
				 */

				if (tp <= 40) {
					lista.add(e);
				}

				e = null;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao listar cirurgias. Mensagem: " + ex.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		return lista;
	}

	@Override
	public List<Cirurgia> listarIniAnestMaiorIniCir(Integer ano) {
		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		Cirurgia e;
		try {
			stmt = conn.prepareStatement(
					"Select i38numseq, i38anoref, i38pront, d38dataexec, c38hinianest, c38hiniexec, c38codsala, c29nomesala From cir38, cir29 Where c38hinianest > c38hiniexec And c38codsala = c29codsala And i38anoref = ?");
			stmt.setInt(1, ano);
			rs = stmt.executeQuery();
			while (rs.next()) {
				e = new Cirurgia();
				e.setNumCirurgia(rs.getInt("i38numseq"));
				e.setAnoCirurgia(rs.getInt("i38anoref"));
				e.setProntuario(rs.getInt("i38pront"));
				e.setDtCirurgia(FormataDataHora.formataData(rs.getString("d38dataexec")));
				e.sethInicioAnest(FormataDataHora.formataHora(rs.getString("c38hinianest")));
				e.sethInicioCirur(FormataDataHora.formataHora(rs.getString("c38hiniexec")));
				e.setSalaCirurcica(rs.getString("c38codsala") + " - " + rs.getString("c29nomesala"));

				Integer hi = rs.getInt("c38hinianest");
				Integer hf = rs.getInt("c38hiniexec");
				Integer tp = hi - hf;

				if (tp <= 40) {
					lista.add(e);
				}

				e = null;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao listar cirurgias. Mensagem: " + ex.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		return lista;
	}

	@Override
	public List<Cirurgia> listarFimAnestMenorFimCir(Integer ano) {
		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		Cirurgia e;
		try {
			stmt = conn.prepareStatement(
					"Select i38numseq, i38anoref, i38pront, d38dataexec, c38hfimanest, c38hfimexec, c38codsala, c29nomesala From cir38, cir29 Where c38hfimanest < c38hfimexec And c38codsala = c29codsala And i38anoref = ?");
			stmt.setInt(1, ano);
			rs = stmt.executeQuery();
			while (rs.next()) {
				e = new Cirurgia();
				e.setNumCirurgia(rs.getInt("i38numseq"));
				e.setAnoCirurgia(rs.getInt("i38anoref"));
				e.setProntuario(rs.getInt("i38pront"));
				e.setDtCirurgia(FormataDataHora.formataData(rs.getString("d38dataexec")));
				e.sethFimAnest(FormataDataHora.formataHora(rs.getString("c38hfimanest")));
				e.setHfimCirur(FormataDataHora.formataHora(rs.getString("c38hfimexec")));
				e.setSalaCirurcica(rs.getString("c38codsala") + " - " + rs.getString("c29nomesala"));

				Integer hi = rs.getInt("c38hfimanest");
				Integer hf = rs.getInt("c38hfimexec");
				Integer tp = hi - hf;

				/*
				 * se o tempo de anestesia for menor que 40 ou igual adiciona na
				 * lista
				 */
				if (tp <= 40) {
					lista.add(e);
				}

				e = null;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao listar cirurgias. Mensagem: " + ex.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		return lista;
	}

	@Override
	public List<Cirurgia> listarPorte(String porte, Integer ano) {
		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		Cirurgia e;
		try {
			stmt = conn.prepareStatement("Select i38numseq, i38anoref, i38pront, d38dataexec,c38hiniexec, "
					+ "c38hfimexec, c38codsala, c29nomesala, c38porte From cir38, cir29 Where c38codsala = c29codsala And i38anoref = ? And c38porte = ?");
			stmt.setInt(1, ano);
			stmt.setString(2, porte);
			rs = stmt.executeQuery();
			while (rs.next()) {
				e = new Cirurgia();
				e.setNumCirurgia(rs.getInt("i38numseq"));
				e.setAnoCirurgia(rs.getInt("i38anoref"));
				e.setProntuario(rs.getInt("i38pront"));
				e.setDtCirurgia(FormataDataHora.formataData(rs.getString("d38dataexec")));
				e.sethInicioCirur(FormataDataHora.formataHora(rs.getString("c38hiniexec")));
				e.setHfimCirur(FormataDataHora.formataHora(rs.getString("c38hfimexec")));
				e.setSalaCirurcica(rs.getString("c38codsala") + " - " + rs.getString("c29nomesala"));
				e.setPorte(rs.getString("c38porte"));

				lista.add(e);
				e = null;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao listar cirurgias. Mensagem: " + ex.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		return lista;
	}

	@Override
	public List<Cirurgia> listaCirurgiasRealizadasClicnica(String dtInicio, String dtFim, String codClin) {
		dtInicio = FormataDataHora.tirarBarrasData(dtInicio);
		dtFim = FormataDataHora.tirarBarrasData(dtFim);

		Connection conn = new ConexaoOpenbase().getConnection();
		ResultSet rs = null;

		String sql = "Select d38dataexec, i38numseq, i38anoref, i38pront, i38numbolet, c38hinianest, "
				+ "c38hiniexec,c38hfimexec, c38hentrec, c38hsairec, "
				+ "c38hfimanest, c38hentrec, c38salarec,c38codsala, c29nomesala,c38porte "
				+ "From tsql.cir38, tsql.cir29 Where c38codsala = c29codsala And c38codclin = ? And d38dataexec Between ? And ?";

		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		Cirurgia c;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, codClin);
			stmt.setString(2, dtInicio);
			stmt.setString(3, dtFim);

			rs = stmt.executeQuery();
			while (rs.next()) {
				c = new Cirurgia();
				c.setDtCirurgia(FormataDataHora.formataData(rs.getString("d38dataexec")));
				c.setNumCirurgia(rs.getInt("i38numseq"));
				c.setAnoCirurgia(rs.getInt("i38anoref"));
				c.setProntuario(rs.getInt("i38pront"));
				c.setNumBoletim(rs.getInt("i38numbolet"));
				c.sethInicioCirur(FormataDataHora.formataHora(rs.getString("c38hiniexec")));
				c.setHfimCirur(FormataDataHora.formataHora(rs.getString("c38hfimexec")));
				c.setTempoCirur(
						FormataDataHora.calculaDiffHora(FormataDataHora.formataHora(rs.getString("c38hiniexec")),
								FormataDataHora.formataHora(rs.getString("c38hfimexec"))));
				c.sethInicioAnest(FormataDataHora.formataHora(rs.getString("c38hinianest")));
				c.sethFimAnest(FormataDataHora.formataHora(rs.getString("c38hfimanest")));
				c.setTempoAnest(
						FormataDataHora.calculaDiffHora(FormataDataHora.formataHora(rs.getString("c38hinianest")),
								FormataDataHora.formataHora(rs.getString("c38hfimanest"))));
				c.sethEntrec(FormataDataHora.formataHora(rs.getString("c38hentrec")));
				c.sethSairec(FormataDataHora.formataHora(rs.getString("c38hsairec")));
				c.setTempoRPA(FormataDataHora.calculaDiffHora(FormataDataHora.formataHora(rs.getString("c38hentrec")),
						FormataDataHora.formataHora(rs.getString("c38hsairec"))));
				c.setSalaCirurcica(rs.getString("c38codsala") + " - " + rs.getString("c29nomesala"));
				c.setPorte(rs.getString("c38porte"));
				lista.add(c);
				c = null;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao listar Cirurgias. Mensagem: " + ex.getMessage());
		} finally {
			try {

			} catch (Throwable ex) {

			}
		}
		return lista;
	}

	@Override
	public List<Cirurgia> listarCampoEncaminhaVazio(Integer ano) {
		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		Cirurgia e;
		try {
			stmt = conn.prepareStatement("Select i38numseq,i38anoref,d38dataexec from cir38 where c38encaminha = '' and i38anoref = ?");
			stmt.setInt(1, ano);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				e = new Cirurgia();
				e.setNumCirurgia(rs.getInt("i38numseq"));
				e.setAnoCirurgia(rs.getInt("i38anoref"));
				e.setDtCirurgia(FormataDataHora.formataData(rs.getString("d38dataexec")));
				// e.sethInicioCirur(FormataDataHora.formataHora(rs.getString("c38hiniexec")));
				// e.setHfimCirur(FormataDataHora.formataHora(rs.getString("c38hfimexec")));

				lista.add(e);
				e = null;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao listar cirurgias. Mensagem: " + ex.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		return lista;
	}

	
	
	@Override
	public List<Cirurgia> listaCirurgiasRealizadasCID(Integer ano) {
				
		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		String[] meses = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "TOTAL" };
		
		// Traz cirurgias agrupadas por tipo, condição são as salas 8 (Centro Obstétrico) dentro de um período
		//String sql = "select i38cid10 from cir38 where (c38codsala like '8%') and d38dataexec >= ? and d38dataexec <= ? group by i38cid10";
		String sql = "select i39codproc from tsql.cir39, tsql.cir38 where (c38codsala like '8%') and d39dataexec >= ? and d39dataexec <= ?  and i39numseq = i38numseq and i38anoref = i39anoref group by i39codproc";
		
		
		//String sql1 = "select concat(ia8pdescr, ia8compos) as descrCID from inta8 where ia8categor = ? and ia8numseq = ?";
		// Traz descrição dos procedimentos
		String sql1 = "select concat(ib9pdescr, ib9compos) as procedimento from intb9 where ib9codigo = ?";
		
		//String sql2 = "select count(*) as qtd1 from cir38 where (c38codsala like '8%') and i38cid10 = ? and d38dataexec >= ? and d38dataexec <= ?  group by i38cid10";
		String sql2 = "select count(*) as qtd1 from tsql.cir39, tsql.cir38 where (c38codsala like '8%') and i39codproc = ? and d39dataexec >= ? and d39dataexec <= ?  and i39numseq = i38numseq and i38anoref = i39anoref group by i39codproc";
		
		
		Connection conn = new ConexaoOpenbase().getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		Cirurgia c;
		String dtInicioTotal = "";
		String dtFimTotal = "";
		dtInicioTotal = ano.toString() + "0101";
		dtFimTotal = ano.toString() + "1231";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dtInicioTotal);
			stmt.setString(2, dtFimTotal);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				String proc = "";
				c = new Cirurgia();

				c.setCodProcedimento(rs.getInt("i39codproc"));

				Connection conn1 = new ConexaoOpenbase().getConnection();
				ResultSet rs1 = null;
				PreparedStatement stmt1 = null;
				try {
					proc = c.getCodProcedimento().toString();// p.getCpfProfissional().toString();
					stmt1 = conn1.prepareStatement(sql1);
					
					stmt1.setString(1, proc);
					
					
					rs1 = stmt1.executeQuery();
					if (rs1.next()) {
						c.setDescrProcedimento(rs1.getString("procedimento"));// setNomeProfissional(rs1.getString("ic0nome"));
					}
				}

				catch (Exception e) {
					System.out.println("Erro ao listar o relatório. Mensagem: " + e.getMessage());
				} finally {
					try {
						stmt1.close();
						conn1.close();
					} catch (Throwable ex) {
						System.out.println(
								"Erro ao fechar operações de busca neste relatório . Mensagem: " + ex.getMessage());
					}
				}

				for (String mes : meses) {
					String dtInicio = "";
					String dtFim = "";

					if (mes == "TOTAL") {
						dtInicio = ano.toString() + "01" + "01";
						dtFim = ano.toString() + "12" + "31";
					} else {
						dtInicio = ano.toString() + mes + "01";
						dtFim = ano.toString() + mes + "31";
					}

					Connection conn2 = new ConexaoOpenbase().getConnection();
					ResultSet rs2 = null;
					PreparedStatement stmt2 = null;

					try {
						stmt2 = conn2.prepareStatement(sql2);
						stmt2.setString(1, proc);
						stmt2.setString(2, dtInicio);
						stmt2.setString(3, dtFim);
						rs2 = stmt2.executeQuery();
						while (rs2 != null && rs2.next()) {

							if (mes == "01") {
								c.setQtdJan(rs2.getInt("qtd1"));

							} else if (mes == "02") {

								c.setQtdFev(rs2.getInt("qtd1"));
							} else if (mes == "03") {

								c.setQtdMar(rs2.getInt("qtd1"));
							} else if (mes == "04") {

								c.setQtdAbr(rs2.getInt("qtd1"));
							} else if (mes == "05") {

								c.setQtdMai(rs2.getInt("qtd1"));
							} else if (mes == "06") {

								c.setQtdJun(rs2.getInt("qtd1"));
							} else if (mes == "07") {

								c.setQtdJul(rs2.getInt("qtd1"));
							} else if (mes == "08") {

								c.setQtdAgo(rs2.getInt("qtd1"));
							} else if (mes == "09") {

								c.setQtdSet(rs2.getInt("qtd1"));
							} else if (mes == "10") {

								c.setQtdOut(rs2.getInt("qtd1"));
							} else if (mes == "11") {

								c.setQtdNov(rs2.getInt("qtd1"));
							} else if (mes == "12") {

								c.setQtdDez(rs2.getInt("qtd1"));
							} else if (mes == "TOTAL") {

								c.setTotal(rs2.getInt("qtd1"));
							}
						}

					} catch (Exception e) {
						System.out.println("Erro aaao listar o relatório. Mensagem: " + e.getMessage());
					} finally {
						try {
							stmt2.close();
							conn2.close();
						} catch (Throwable ex) {
							System.out.println("Erro ao fechar operações dede busca neste relatório. Mensagem: "
									+ ex.getMessage());
						}
					}

				}

				Integer jan = c.getQtdJan();
				Integer fev = c.getQtdFev();
				Integer mar = c.getQtdMar();
				Integer abr = c.getQtdAbr();
				Integer mai = c.getQtdMai();
				Integer jun = c.getQtdJun();
				Integer jul = c.getQtdJul();
				Integer ago = c.getQtdAgo();
				Integer set = c.getQtdSet();
				Integer out = c.getQtdOut();
				Integer nov = c.getQtdNov();
				Integer dez = c.getQtdDez();
				Integer total = jan + fev + mar + abr + +mai + jun + jul + ago + set + out + nov + dez;
				c.setTotal(total);
				
				lista.add(c);
				c = null;
				total = 0;
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar anestesiaaa. Mensagem: " + e.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		//Comparator<Anestesia> c = (s1, s2) -> s1.getNomeProfissional().compareTo(s2.getNomeProfissional());
		//lista.sort(c);
		
		return lista;
	}
}
