<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Professor"%>

<%
	ArrayList<Professor> professores = (ArrayList<Professor>) request.getAttribute("professores");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Nome Professor</th>
			<th></th>
		</tr>
		<%
			for (Professor professor : professores) {
		%>
		<tr>
			<td><%=professor.getNome()%></td>
			<td><a href="http://localhost:8080/Prova1/exibirProfessor?idprofessor=<%=professor.getIdProfessor()%>">Mais detalhes</a></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>