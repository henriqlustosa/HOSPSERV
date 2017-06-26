package hspm.clinica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hspm.util.ConexaoOpenbase;

public class ClinicaDAOOpenbase implements ClinicaDAO {

	@Override
	public List<Clinica> listarClinicas() {
		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "Select c14codclin, c14nomec From tsql.cen14 Order by c14nomec";
		List<Clinica> lista = new ArrayList<Clinica>();
		
		Clinica c;
		try {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				c = new Clinica();
				c.setCodClinica(rs.getString("c14codclin"));
				c.setDescricao(rs.getString("c14nomec"));
				lista.add(c);
				c = null;
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao listar clinicas. Mensagem: " + ex.getMessage());
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
