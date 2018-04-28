package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Professor;

public class ProfessorDAO {
	
	private Connection conexao;

	public ProfessorDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public ArrayList<Professor> getProfessores() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Professor> resultado = new ArrayList<Professor>();

		try {
			ps = conexao.prepareStatement("SELECT idprofessor, nome, datanascimento, nomemae, titulacao\r\n" + 
										  "FROM professor\r\n" + 
										  "ORDER BY nome");

			rs = ps.executeQuery();

			while (rs.next()) {
				resultado.add(new Professor(rs.getInt("idprofessor"),
											rs.getString("nome"),
											rs.getDate("datanascimento").toString(),
											rs.getString("nomemae"),
											rs.getInt("titulacao")));
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public Professor getProfessorer(int idProfessor) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Professor resultado = null;

		try {
			ps = conexao.prepareStatement("SELECT idprofessor, nome, datanascimento, nomemae, titulacao\r\n" + 
										  "FROM professor\r\n" + 
										  "WHERE idprofessor = ?");
			
			ps.setInt(1, idProfessor);

			rs = ps.executeQuery();
			rs.first();			

			resultado = new Professor(rs.getInt("idprofessor"),
									  rs.getString("nome"),
									  rs.getDate("datanascimento").toString(),
									  rs.getString("nomemae"),
									  rs.getInt("titulacao"));
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
}
