<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ page import="model.Cursos"%>
<%@ page import="model.Periodos"%>
<%@ page import="model.Coordenadores"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Cursos> listaCursos = (ArrayList<Cursos>) request.getAttribute("listaCursos");
ArrayList<Periodos> listaPeriodos = (ArrayList<Periodos>) request.getAttribute("listaPeriodos");
Coordenadores coord = (Coordenadores)request.getAttribute("coordenador");

%>
<title>Update </title>
<link rel="stylesheet" href="cadastro.css">
</head>
<body>
	<section class="area-login">
		<div class="login">
			<div>
				<img src="/img/transferir-removebg-preview.png" alt="">
			</div>
			<h1>Editar Coordenador</h1>
			<form method="POST" action="edite">
				<input type="text" name="nome"
					placeholder="Informe o nome do coordenador" autofocus value ="<%=coord.getNome()%>"> 
					
					<select name="curso">
					<%
					for (int i = 0; i < listaCursos.size(); i++) {
					%>
					<%
					Cursos curso = listaCursos.get(i);
					String padrao = "";
						if(curso.getNome().equals(coord.getCursos().getNome())){
							padrao = "selected";
						}
					%>
					<option <%= padrao %> value="<%=curso.getId()%>">
						<%=curso.getNome()%>
					</option>
					<%
					}
					%>
				</select> <select name="periodo">
					<%
					for (int i = 0; i < listaPeriodos.size(); i++) {
					%>
					<%
					Periodos periodo = listaPeriodos.get(i);
					%>
					<option value="<%=periodo.getId()%>">
						<%=periodo.getDia() + " - " + periodo.getHorario()%>
					</option>
					<%
					}
					%>
				</select> <button class="botao" type="submit">Editar</button>
			</form>
		</div>
	</section>
</body>
</html>