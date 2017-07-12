package hspm.centrocirurgico.anestesia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import hspm.util.ConexaoOpenbase;
import hspm.util.FormataDataHora;

public class AnestesiaDAOOpenbase implements AnestesiaDAO {

	public List<Anestesia> listar() {

		Connection conn = new ConexaoOpenbase().getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sql = "select c30codanest,c30nomeanest from cir30";
		List<Anestesia> lista = new ArrayList<Anestesia>();
		Anestesia p;
		try {
			stmt = conn.prepareStatement(sql);
			// stmt.setInt(1, ano);
			rs = stmt.executeQuery();
			while (rs.next()) {
				p = new Anestesia();
				p.setCodAnestesia(rs.getString("c30codanest"));
				p.setDescAnestesia(rs.getString("c30nomeanest"));
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
				System.out.println("Erro ao fechar operações deeee busca. Mensagem: " + ex.getMessage());
			}
		}

		return lista;
	}

	@Override
	public List<Anestesia> listarQuantidadeAnestesia(Integer ano) {

		List<Anestesia> lista = new ArrayList<Anestesia>();
		String[] meses = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String[] nomeAnestesia = { "Combinada", "Geral", "Local", "Peridural", "Raquidiana", "Sedação" };
		String[] tipoCodAnestesia = { "codAnestesia1", "codAnestesia2" };

		String sql = "";

		String sqlCombinada1 = "select count(*) as qtd1 from cir38 where (c38codanest1 = '07' or  c38codanest1 = '03' or c38codanest1 = '04')  and   d38dataexec >= ? and d38dataexec <= ? ";
		String sqlGeral1 = "select count(*) as qtd1 from cir38 where (c38codanest1 = '02' or  c38codanest1 = '01')  and   d38dataexec >= ? and d38dataexec <= ? ";
		String sqlLocal1 = "select count(*) as qtd1 from cir38 where (c38codanest1 = '12' or  c38codanest1 = '13' or c38codanest1 = '15' or c38codanest1 = '16' or  c38codanest1 = '14' or c38codanest1 = '06' or c38codanest1 = '10' or c38codanest1 = '17' or  c38codanest1 = '18')  and   d38dataexec >= ? and d38dataexec <= ? ";
		String sqlPeridural1 = "select count(*) as qtd1 from cir38 where (c38codanest1 = '09') and d38dataexec >= ? and d38dataexec <= ? ";
		String sqlRaquidiana1 = "select count(*) as qtd1 from cir38 where (c38codanest1 = '08') and d38dataexec >= ? and d38dataexec <= ? ";
		String sqlSedacao1 = "select count(*) as qtd1 from cir38 where (c38codanest1 = '05')  and   d38dataexec >= ? and d38dataexec <= ? ";
		String sqlCombinada2 = "select count(*) as qtd1 from cir38 where (c38codanest2 = '07' or  c38codanest2 = '03' or c38codanest2 = '04') and   d38dataexec >= ? and d38dataexec <= ? ";
		String sqlGeral2 = "select count(*) as qtd1 from cir38 where (c38codanest2 = '02' or  c38codanest2 = '01') and   d38dataexec >= ? and d38dataexec <= ? ";
		String sqlLocal2 = "select count(*) as qtd1 from cir38 where (c38codanest2 = '12' or  c38codanest2 = '13' or c38codanest2 = '15' or c38codanest2 = '16' or  c38codanest2 = '14' or c38codanest2 = '06' or c38codanest2 = '10' or c38codanest2 = '17' or  c38codanest2 = '18') and   d38dataexec >= ? and d38dataexec <= ? ";
		String sqlPeridural2 = "select count(*) as qtd1 from cir38 where  (c38codanest2 = '09') and   d38dataexec >= ? and d38dataexec <= ? ";
		String sqlRaquidiana2 = "select count(*) as qtd1 from cir38 where  (c38codanest2 = '08') and   d38dataexec >= ? and d38dataexec <= ? ";
		String sqlSedacao2 = "select count(*) as qtd1 from cir38 where  (c38codanest2 = '05') and   d38dataexec >= ? and d38dataexec <= ? ";

		Anestesia p;

		for (String nomeAnest : nomeAnestesia) {
			p = new Anestesia();

			p.setDescAnestesia(nomeAnest);

			for (String tipoCodigoAnestesia : tipoCodAnestesia) {
				if (tipoCodigoAnestesia == "codAnestesia1") {
					if (nomeAnest == "Combinada") {
						sql = sqlCombinada1;
					} else if (nomeAnest == "Geral") {

						sql = sqlGeral1;
					} else if (nomeAnest == "Local") {

						sql = sqlLocal1;
					} else if (nomeAnest == "Peridural") {

						sql = sqlPeridural1;
					} else if (nomeAnest == "Raquidiana") {

						sql = sqlRaquidiana1;
					} else if (nomeAnest == "Sedação") {

						sql = sqlSedacao1;
					} else if (nomeAnest == "Combinada") {
						sql = sqlCombinada2;
					} else if (nomeAnest == "Geral") {

						sql = sqlGeral2;
					} else if (nomeAnest == "Local") {

						sql = sqlLocal2;
					} else if (nomeAnest == "Peridural") {

						sql = sqlPeridural2;
					} else if (nomeAnest == "Raquidiana") {

						sql = sqlRaquidiana2;
					} else if (nomeAnest == "Sedação") {

						sql = sqlSedacao2;
					}
				}
				for (String mes : meses) {
					String dtInicio = "";
					String dtFim = "";
					dtInicio = ano.toString() + mes + "01";
					dtFim = ano.toString() + mes + "31";
					Connection conn = new ConexaoOpenbase().getConnection();
					ResultSet rs = null;
					PreparedStatement stmt = null;

					try {
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, dtInicio);
						stmt.setString(2, dtFim);
						rs = stmt.executeQuery();
						while (rs != null && rs.next()) {

							if (mes == "01") {
								p.setQtdJan(rs.getInt("qtd1"));

							} else if (mes == "02") {

								p.setQtdFev(rs.getInt("qtd1"));
							} else if (mes == "03") {

								p.setQtdMar(rs.getInt("qtd1"));
							} else if (mes == "04") {

								p.setQtdAbr(rs.getInt("qtd1"));
							} else if (mes == "05") {

								p.setQtdMai(rs.getInt("qtd1"));
							} else if (mes == "06") {

								p.setQtdJun(rs.getInt("qtd1"));
							} else if (mes == "07") {

								p.setQtdJul(rs.getInt("qtd1"));
							} else if (mes == "08") {

								p.setQtdAgo(rs.getInt("qtd1"));
							} else if (mes == "09") {

								p.setQtdSet(rs.getInt("qtd1"));
							} else if (mes == "10") {

								p.setQtdOut(rs.getInt("qtd1"));
							} else if (mes == "11") {

								p.setQtdNov(rs.getInt("qtd1"));
							} else if (mes == "12") {

								p.setQtdDez(rs.getInt("qtd1"));
							}

						}

					} catch (Exception e) {
						System.out.println("Erro ao listar anestesia. Mensagem: " + e.getMessage());
					} finally {
						try {
							stmt.close();
							conn.close();
						} catch (Throwable ex) {
							System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
						}
					}

				}
			}
			Integer jan = p.getQtdJan();
			Integer fev = p.getQtdFev();
			Integer mar = p.getQtdMar();
			Integer abr = p.getQtdAbr();
			Integer mai = p.getQtdMai();
			Integer jun = p.getQtdJun();
			Integer jul = p.getQtdJul();
			Integer ago = p.getQtdAgo();
			Integer set = p.getQtdSet();
			Integer out = p.getQtdOut();
			Integer nov = p.getQtdNov();
			Integer dez = p.getQtdDez();

			Integer total = jan + fev + mar + abr + +mai + jun + jul + ago + set + out + nov + dez;
			p.setTotal(total);
			lista.add(p);

			p = null;
			total = 0;
		}

		return lista;

	}

	public List<Anestesia> relatorioNumero3(Integer ano) {

		List<Anestesia> lista = new ArrayList<Anestesia>();
		String[] meses = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "TOTAL" };
		String sql = "select i40cpfmed from cir40 where c40codatu ='02'and d40dataexec >= ? and d40dataexec <= ? group by i40cpfmed";
		String sql1 = "select ic0nome from intc0 where ic0cpf = ?";
		String sql2 = "select count(*) as qtd1 from cir40 where c40codatu ='02' and i40cpfmed = ? and d40dataexec >= ? and d40dataexec <= ?  group by i40cpfmed";

		Connection conn = new ConexaoOpenbase().getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;

		Anestesia p;
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
				String cpf = "";
				p = new Anestesia();

				p.setCpfProfissional(rs.getLong("i40cpfmed"));

				Connection conn1 = new ConexaoOpenbase().getConnection();
				ResultSet rs1 = null;
				PreparedStatement stmt1 = null;
				try {
					cpf = p.getCpfProfissional().toString();
					stmt1 = conn1.prepareStatement(sql1);
					stmt1.setString(1, cpf);
					rs1 = stmt1.executeQuery();
					if (rs1.next()) {

						p.setNomeProfissional(rs1.getString("ic0nome"));
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
						stmt2.setString(1, cpf);
						stmt2.setString(2, dtInicio);
						stmt2.setString(3, dtFim);
						rs2 = stmt2.executeQuery();
						while (rs2 != null && rs2.next()) {

							if (mes == "01") {
								p.setQtdJan(rs2.getInt("qtd1"));

							} else if (mes == "02") {

								p.setQtdFev(rs2.getInt("qtd1"));
							} else if (mes == "03") {

								p.setQtdMar(rs2.getInt("qtd1"));
							} else if (mes == "04") {

								p.setQtdAbr(rs2.getInt("qtd1"));
							} else if (mes == "05") {

								p.setQtdMai(rs2.getInt("qtd1"));
							} else if (mes == "06") {

								p.setQtdJun(rs2.getInt("qtd1"));
							} else if (mes == "07") {

								p.setQtdJul(rs2.getInt("qtd1"));
							} else if (mes == "08") {

								p.setQtdAgo(rs2.getInt("qtd1"));
							} else if (mes == "09") {

								p.setQtdSet(rs2.getInt("qtd1"));
							} else if (mes == "10") {

								p.setQtdOut(rs2.getInt("qtd1"));
							} else if (mes == "11") {

								p.setQtdNov(rs2.getInt("qtd1"));
							} else if (mes == "12") {

								p.setQtdDez(rs2.getInt("qtd1"));
							} else if (mes == "TOTAL") {

								p.setTotal(rs2.getInt("qtd1"));
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

				lista.add(p);
				p = null;

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
		Comparator<Anestesia> c = (s1, s2) -> s1.getNomeProfissional().compareTo(s2.getNomeProfissional());
		lista.sort(c);
		return lista;

	}

	public List<Anestesia> relatorioNumero4(Integer ano) {
		String dtInicio = "";
		String dtFim = "";

		List<Anestesia> lista = new ArrayList<Anestesia>();
		List<Long> cpfProfissional = new ArrayList<Long>();
		String[] meses = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String sql = "select i40cpfmed from cir40 where c40codatu ='02'and d40dataexec >= ? and d40dataexec <= ? group by i40cpfmed";
		String sql1 = "select ic0nome from intc0 where ic0cpf = ?";
		String sql2 = "select i40numseq, i40anoref from cir40 where i40cpfmed= ? and c40codatu ='02'and d40dataexec >= ? and d40dataexec <= ?";
		String sql3 = "select c38hinianest,c38hfimanest from cir38 where i38numseq = ? and i38anoref = ? ";

		Connection conn = new ConexaoOpenbase().getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;

		Anestesia p;
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
				cpfProfissional.add(rs.getLong("i40cpfmed"));
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
		for (Long cpf : cpfProfissional) {
			String strCpf = "";

			p = new Anestesia();

			p.setCpfProfissional(cpf);
			strCpf = cpf.toString();

			Connection conn1 = new ConexaoOpenbase().getConnection();
			ResultSet rs1 = null;
			PreparedStatement stmt1 = null;
			try {

				stmt1 = conn1.prepareStatement(sql1);
				stmt1.setString(1, strCpf);
				rs1 = stmt1.executeQuery();
				if (rs1.next()) {

					p.setNomeProfissional(rs1.getString("ic0nome"));
				}

			}

			catch (Exception e) {
				System.out.println("Erro ao listarr o relatório. Mensagem: " + e.getMessage());
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

				Connection conn2 = new ConexaoOpenbase().getConnection();
				ResultSet rs2 = null;
				PreparedStatement stmt2 = null;
				dtInicio = ano.toString() + mes + "01";
				dtFim = ano.toString() + mes + "31";

				try {
					stmt2 = conn2.prepareStatement(sql2);
					stmt2.setString(1, strCpf);
					stmt2.setString(2, dtInicio);
					stmt2.setString(3, dtFim);

					rs2 = stmt2.executeQuery();
					while (rs2 != null && rs2.next()) {
						p.setCodCirurgia(rs2.getInt("i40numseq"));
						p.setAnoReferencia(rs2.getInt("i40anoref"));
						Integer codCirurgia = p.getCodCirurgia();
						Integer anoReferencia = p.getAnoReferencia();
						Connection conn3 = new ConexaoOpenbase().getConnection();
						ResultSet rs3 = null;
						PreparedStatement stmt3 = null;

						try {
							stmt3 = conn3.prepareStatement(sql3);
							stmt3.setInt(1, codCirurgia);
							stmt3.setInt(2, anoReferencia);

							rs3 = stmt3.executeQuery();

							while (rs3 != null && rs3.next()) {

								if (mes == "01") {
									p.setHrsJan(FormataDataHora.calculaSomaTEmpo(p.getHrsJan(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));

								} else if (mes == "02") {

									p.setHrsFev(FormataDataHora.calculaSomaTEmpo(p.getHrsFev(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "03") {

									p.setHrsMar(FormataDataHora.calculaSomaTEmpo(p.getHrsMar(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "04") {

									p.setHrsAbr(FormataDataHora.calculaSomaTEmpo(p.getHrsAbr(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "05") {

									p.setHrsMai(FormataDataHora.calculaSomaTEmpo(p.getHrsMai(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "06") {

									p.setHrsJun(FormataDataHora.calculaSomaTEmpo(p.getHrsJun(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "07") {

									p.setHrsJul(FormataDataHora.calculaSomaTEmpo(p.getHrsJul(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "08") {

									p.setHrsAgo(FormataDataHora.calculaSomaTEmpo(p.getHrsAgo(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "09") {

									p.setHrsSet(FormataDataHora.calculaSomaTEmpo(p.getHrsSet(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "10") {

									p.setHrsOut(FormataDataHora.calculaSomaTEmpo(p.getHrsOut(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "11") {

									p.setHrsNov(FormataDataHora.calculaSomaTEmpo(p.getHrsNov(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								} else if (mes == "12") {

									p.setHrsDez(FormataDataHora.calculaSomaTEmpo(p.getHrsDez(),
											FormataDataHora.calculaDiffHora(
													FormataDataHora.formataHora(rs3.getString("c38hinianest")),
													FormataDataHora.formataHora(rs3.getString("c38hfimanest")))));
								}

							}

						} catch (Exception e) {
							System.out.println("Erro aaao listar o relatório. Mensagem: " + e.getMessage());
						} finally {
							try {
								stmt3.close();
								conn3.close();
							} catch (Throwable ex) {
								System.out.println("Erro ao fechar operações dede busca neste relatório. Mensagem: "
										+ ex.getMessage());
							}
						}

					}

				} catch (Exception e) {
					System.out.println("Erro ao listar o relatório. Mensagem: " + e.getMessage());
				} finally {
					try {
						stmt2.close();
						conn2.close();
					} catch (Throwable ex) {
						System.out.println(
								"Erro ao fechar operações dede busca neste relatório. Mensagem: " + ex.getMessage());
					}
				}

			}
			p.setHrsTotal(FormataDataHora.calculaSomaTotal(p.getHrsJan(), p.getHrsFev(), p.getHrsMar(), p.getHrsAbr(),
					p.getHrsMai(), p.getHrsJun(), p.getHrsJul(), p.getHrsAgo(), p.getHrsSet(), p.getHrsOut(),
					p.getHrsNov(), p.getHrsDez()));
			lista.add(p);
			p = null;
		}

		Comparator<Anestesia> c = (s1, s2) -> s1.getNomeProfissional().compareTo(s2.getNomeProfissional());
		lista.sort(c);
		return lista;

	}

}
