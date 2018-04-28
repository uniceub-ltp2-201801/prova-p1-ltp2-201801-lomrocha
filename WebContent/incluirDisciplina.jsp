<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.Professor"%>
<%
	Professor professor = (Professor) session.getAttribute("professor");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 style="padding-left: 220px;">Incluir Disciplina</h3>
	<form action="incluirDisciplina">
		<table>
			<tr>
				<th>Nome da Disciplina</th>
				<th>Curso da Disciplina</th>
				<th>Carga Horária</th>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<td><input type="text" name="nome"></td>
				<td><input type="text" name="curso"></td>
				<td><input type="text" name="cargahoraria"></td>
				<td><input type="submit" value="Incluir!"></td>
				<td><input type="hidden" name="idprofessor" value="<%=professor.getIdProfessor()%>"></td>
			</tr>
		</table>
	</form>
</body>
</html>