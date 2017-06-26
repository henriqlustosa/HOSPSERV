package hspm.profissional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import hspm.util.ConexaoOpenbase;

public class ProfissionalDAOOpenbase {

	public static String getNomeProfissional(String cpf) {
		String _cpf = cpf.replace("+", "").trim();
		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String nome = "";
		try {
			stmt = conn.prepareStatement(
					"Select ic0nome From intc0 Where ic0cpf = ?");
			stmt.setString(1, _cpf);
			rs = stmt.executeQuery();
			if (rs.next()) {
				nome = rs.getString("ic0nome");
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
		
		return nome;
	}

}
