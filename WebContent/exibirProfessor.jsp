<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.Professor"%>
<%@ page import="model.Disciplina"%>
<%@ page import="java.util.ArrayList"%>

<%
	Professor professor = (Professor) request.getAttribute("professor");
	ArrayList<Disciplina> disciplinas = (ArrayList<Disciplina>) request.getAttribute("disciplinas");
	boolean sucesso = (boolean) request.getAttribute("sucesso");
	session.setAttribute("professor", professor);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (sucesso) {
	%>
	<h3>Disciplina incluída com sucesso</h3>
	<%
		}
	%>
	<table>
		<tr>
			<th>ID Professor</th>
			<th>Nome Professor</th>
			<th>Data Nascimento</th>
			<th>Nome Mãe</th>
			<th>Titulação</th>
		</tr>
		<tr>
			<td><%=professor.getIdProfessor()%></td>
			<td><%=professor.getNome()%></td>
			<td><%=professor.getDataNascimento()%></td>
			<td><%=professor.getNomeMae()%></td>
			<td><%=professor.getTitulacao()%></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>ID Disciplina</th>
			<th>Nome Disciplina</th>
			<th>Curso</th>
			<th>Carga Horária</th>
			<th></th>
		</tr>
		<%
			for (Disciplina disciplina : disciplinas) {
		%>
		<tr>
			<td><%=disciplina.getIdDisciplina()%></td>
			<td><%=disciplina.getNome()%></td>
			<td><%=disciplina.getCurso()%></td>
			<td><%=disciplina.getCargaHoraria()%></td>
		</tr>
		<%
			}
		%>
	</table>
	</br>
	<h4>
		<a href="http://localhost:8080/Prova1/incluirDisciplina.jsp">Incluir
			Disciplina</a>
	</h4>
</body>
</html>