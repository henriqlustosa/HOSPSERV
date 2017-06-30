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
				+ "c38hfimanest, c38hentrec, c38salarec,c38codsala, c29nomesala "
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
	public List<Cirurgia> listarCampoEncaminhaVazio() {
		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cirurgia> lista = new ArrayList<Cirurgia>();
		Cirurgia e;
		try {
			stmt = conn.prepareStatement("Select i38numseq,i38anoref,d38dataexec from cir38 where c38encaminha = '' ");
			// stmt.setInt(1, ano);
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



}
