package hspm.centrocirurgico.anestesia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hspm.centrocirurgico.cirurgia.Cirurgia;
import hspm.util.ConexaoOpenbase;

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
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}

		return lista;
	}

	@Override
	public List<Anestesia> listarQuantidadeAnestesia(Integer ano) {
		String codAnestesia = "";
		List<Anestesia> lista = new ArrayList<Anestesia>();
		String[] meses = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String[] tipoCodAnestesia = { "codAnestesia1", "codAnestesia2" };
		Connection conn1 = new ConexaoOpenbase().getConnection();
		ResultSet rs1 = null;
		PreparedStatement stmt1 = null;
		String sql = "";
		String sql1 = "select c30codanest,c30nomeanest from cir30";
		String sql2 = "select count(*) as qtd1 from cir38 where c38codanest1 = ? and   d38dataexec >= ? and d38dataexec <= ? group by c38codanest1";
		String sql3 = "select count(*) as qtd1 from cir38 where c38codanest2 = ? and   d38dataexec >= ? and d38dataexec <= ? group by c38codanest2";
		Anestesia p;
		try {
			stmt1 = conn1.prepareStatement(sql1);

			rs1 = stmt1.executeQuery();
			while (rs1.next()) {
				p = new Anestesia();

				p.setCodAnestesia(rs1.getString("c30codanest"));

				p.setDescAnestesia(rs1.getString("c30nomeanest"));
				codAnestesia = p.getCodAnestesia();
				for (String tipoCodigoAnestesia : tipoCodAnestesia) {
					if (tipoCodigoAnestesia == "codAnestesia1")
						sql = sql2;
					else
						sql = sql3;
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
							stmt.setString(1, codAnestesia);
							stmt.setString(2, dtInicio);
							stmt.setString(3, dtFim);
							rs = stmt.executeQuery();
							while (rs != null && rs.next() ) {

								if (mes == "01") {
									p.setQtdJan(rs.getInt("qtd1"));

									
								} else if (mes == "02") {

									p.setQtdFev(rs.getInt("qtd1"));
								} else if (mes == "03") {

									p.setQtdMar(rs.getInt("qtd1"));
								} else if (mes == "04") {

									p.setQtdAbr(rs.getInt("qtd1"));
								} else if (mes == "05") {
									
										
									p.setQtdMai( rs.getInt("qtd1"));
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

				Integer total = jan + fev + mar + abr + + mai + jun + jul + ago + set + out + nov + dez;
				p.setTotal(total);
				lista.add(p);
				p = null;
				total = 0;
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar anestesia. Mensagem: " + e.getMessage());
		} finally {
			try {
				stmt1.close();
				conn1.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}

		return lista;

	}
}
