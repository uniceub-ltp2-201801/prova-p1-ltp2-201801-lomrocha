package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Disciplina;

public class DisciplinaDAO {
	private Connection conexao;

	public DisciplinaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public ArrayList<Disciplina> getDisciplinas(int idProfessor){
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Disciplina> resultado = new ArrayList<Disciplina>();

		try {
			ps = conexao.prepareStatement("SELECT iddisciplina, idprofessor, nome, curso, cargahoraria\r\n" + 
										  "FROM disciplina\r\n" + 
										  "WHERE idprofessor = ?");
			
			ps.setInt(1, idProfessor);

			rs = ps.executeQuery();

			while (rs.next()) {
				resultado.add(new Disciplina(rs.getInt("iddisciplina"),
											 rs.getInt("idprofessor"),
											 rs.getString("nome"),
											 rs.getString("curso"),
											 rs.getInt("cargahoraria")));
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public void incluirDisciplina(int idProfessor, String nome, String curso, int cargaHoraria) {
		PreparedStatement ps = null;
		
		try {
			String query = "INSERT INTO `faculdade`.`disciplina` (`idprofessor`, `nome`, `curso`, `cargahoraria`)\r\n"
					     + "VALUES(?, '?', '?', ?)";
			
			ps = conexao.prepareStatement(query);
			
			ps.setInt(1, idProfessor);
			ps.setString(2, nome);
			ps.setString(3, curso);
			ps.setInt(4, cargaHoraria);
			
			ps.executeUpdate();


			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
