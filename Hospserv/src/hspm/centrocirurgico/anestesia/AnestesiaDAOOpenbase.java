package hspm.centrocirurgico.anestesia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
				//stmt.setInt(1, ano);
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

}
