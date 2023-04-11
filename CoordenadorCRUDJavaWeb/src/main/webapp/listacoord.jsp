<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Coordenadores"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Coordenadores> lista = (ArrayList<Coordenadores>) request.getAttribute("listCoordenador");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista</title>
<link rel="stylesheet" href="coordenador.css">
</head>
<body>
	<h1>Lista de Coordenadores</h1>
	<section class="area-login">
		<div class="login">
			<div>
				<img src="/img/transferir-removebg-preview.png" alt="">
			</div>
			<table id="table">
				<thead>
					<tr>
						<th>Coordenador Id</th>
						<th>Coordenador Nome</th>
						<th>Cursos</th>
						<th>Horario de disponibiliade</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
						String id = String.valueOf(lista.get(i).getId());
					%>
					<tr>
						<td><%=String.valueOf(lista.get(i).getId())%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getCursos().getNome()%> (<%=lista.get(i).getCursos().getSigla()%>)</td>
						<td><%=lista.get(i).getPeriodos().getDia()%> (<%=lista.get(i).getPeriodos().getHorario()%>)</td>
						<td><a href="editar?id=<%=id%>">Editar</a></td>
						<td><a href="deletar?id=<%=id%>">Deletar</a></td>

					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</section>
</body>
</html>