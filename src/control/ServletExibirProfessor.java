package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

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
 * Servlet implementation class ServletExibirProfessor
 */
@WebServlet("/exibirProfessor")
public class ServletExibirProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExibirProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idProfessor = Integer.parseInt(request.getParameter("idprofessor"));
		
		Connection conexao = Conexao.getConexao();
		
		ProfessorDAO pd = new ProfessorDAO(conexao);
		DisciplinaDAO dd = new DisciplinaDAO(conexao);
		
		Professor professor = pd.getProfessorer(idProfessor);
		ArrayList<Disciplina> disciplinas = dd.getDisciplinas(idProfessor);
		
		request.setAttribute("professor",  professor);
		request.setAttribute("disciplinas", disciplinas);
		
		RequestDispatcher rd = request.getRequestDispatcher("exibirProfessor.jsp");

		rd.forward(request, response);
	}

}
