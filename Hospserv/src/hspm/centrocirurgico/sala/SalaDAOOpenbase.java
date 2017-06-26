package hspm.centrocirurgico.sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hspm.util.ConexaoOpenbase;

public class SalaDAOOpenbase implements SalaDAO {

	@SuppressWarnings("null")
	@Override
	public Sala buscarPorSala(String codsala) {

		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Sala sala = null;
		try {
			stmt = conn.prepareStatement("Select c29nomesala From cir29 Where c29codsala = ?");
			stmt.setString(1, codsala);
			rs = stmt.executeQuery();
			if (rs.next()) {
				sala.setNomeSala("c29nomesala");
			}
		} catch (Throwable ex) {
			System.out.println("Erro ao buscar sala. Mensagem: " + ex.getMessage());
		} finally {
			try {
				conn.close();
				rs.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		return sala;
	}

}
