package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.DisciplinaDAO;
import dao.ProfessorDAO;
import model.Disciplina;
import model.Professor;

/**
 * Servlet implementation class ServletIncluirDisciplina
 */
@WebServlet("/incluirDisciplina")
public class ServletIncluirDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncluirDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProfessor = Integer.parseInt(request.getParameter("idprofessor"));
		String nome = request.getParameter("nome");
		String curso = request.getParameter("curso");
		int cargaHoraria = Integer.parseInt(request.getParameter("cargahoraria"));
		
		Connection conexao = Conexao.getConexao();
		
		ProfessorDAO pd = new ProfessorDAO(conexao);
		DisciplinaDAO dd = new DisciplinaDAO(conexao);
		
		Professor professor = pd.getProfessorer(idProfessor);
		
		dd.incluirDisciplina(idProfessor, nome, curso, cargaHoraria);		
		ArrayList<Disciplina> disciplinas = dd.getDisciplinas(idProfessor);
		
		request.setAttribute("professor",  professor);
		request.setAttribute("disciplinas", disciplinas);
		request.setAttribute("sucesso", true);
		
		RequestDispatcher rd = request.getRequestDispatcher("exibirProfessor.jsp");

		rd.forward(request, response);
	}

}
