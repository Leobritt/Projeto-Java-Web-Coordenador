package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.CoordenadorDAO;
import dao.CursoDAO;
import dao.PeriodoDAO;
import model.Coordenadores;
import model.Cursos;
import model.Periodos;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/telaAddCoordenador", "/create", "/editar", "/edite", "/deletar","/addnovo","/addNovoContatoPeriodo" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CoordenadorDAO coorDAO = new CoordenadorDAO();
	Coordenadores coor = new Coordenadores();
	CursoDAO curDAO = new CursoDAO();
	PeriodoDAO perDAO = new PeriodoDAO();
	Cursos cursos = new Cursos();
	Periodos per = new Periodos();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			acessarListaCoordenador(request, response);
		} else if (action.equals("/telaAddCoordenador")) {
			addCoordenador(request, response);
		} else if (action.equals("/editar")) {
			telaEditarCoordenador(request, response);
		} else if (action.equals("/edite")) {
			editarCoordenador(request, response);
		}else if(action.equals("/deletar")) {
			removerCoordenador(request, response);
		}else if(action.equals("/addnovo")) {
			telaAddCursoPeriodo(request, response);
		}else if(action.equals("/addNovoContatoPeriodo")) {
			addCursoPeriodo(request, response);
		}else {
			acessarListaCoordenador(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Integer idCursos = Integer.parseInt(request.getParameter("curso"));
		Integer idPeriodos = Integer.parseInt(request.getParameter("periodo"));
		Coordenadores coordenador = new Coordenadores();

		coordenador.setNome(nome);
		coorDAO.inserirCoordenador(coordenador);

		Coordenadores coord = coorDAO.buscarCoordenadorPeloNome(nome);

		coorDAO.inserirCursoCoordenador(coord.getId(), idCursos);
		coorDAO.inserirPeriodoCoordenador(coord.getId(), idPeriodos);

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void acessarListaCoordenador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Coordenadores> lista = coorDAO.listaCoordenadores();
		request.setAttribute("listCoordenador", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listacoord.jsp");
		rd.forward(request, response);
		lista.forEach(System.out::println);

	}

	protected void addCoordenador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Cursos> listaCursos = curDAO.listaCurso();
		ArrayList<Periodos> listaPeriodos = perDAO.listaPeriodos();
		request.setAttribute("listaCursos", listaCursos);
		request.setAttribute("listaPeriodos", listaPeriodos);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
	}

	protected void telaEditarCoordenador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Coordenadores coord = coorDAO.listaCoordenadoresPeloId(id);
		ArrayList<Cursos> listaCursos = curDAO.listaCurso();
		ArrayList<Periodos> listaPeriodos = perDAO.listaPeriodos();
		request.setAttribute("listaCursos", listaCursos);
		request.setAttribute("listaPeriodos", listaPeriodos);
		request.setAttribute("coordenador", coord);

		RequestDispatcher rd = request.getRequestDispatcher("updateCoor.jsp");
		rd.forward(request, response);

	}

	protected void editarCoordenador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Coordenadores coord = new Coordenadores();
		Cursos cursos = new Cursos();
		Periodos per = new Periodos();
		// Teste de Recebimento
		System.out.println(request.getParameter("id"));
		// vindo null
		System.out.println(request.getParameter("nome"));

		coord.setId(Integer.parseInt(request.getParameter("id")));
		// problema nessa linha, pois está vindo null
		coord.setNome(request.getParameter("nome"));

		Integer idCursoNovo = Integer.parseInt(request.getParameter("curso"));

		Integer idPeriodoNovo = Integer.parseInt(request.getParameter("periodo"));

		cursos.setId(idCursoNovo);
		per.setId(idPeriodoNovo);

		coorDAO.alterarCoordenador(coord);

		curDAO.alterarCurso(coord, cursos);

		perDAO.alterarPeriodo(coord, per);

		response.sendRedirect("main");

	}

	protected void removerCoordenador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Coordenadores coord = new Coordenadores();
		coord.setId(id);
		coorDAO.deletarCoordenador(coord);
		
		response.sendRedirect("main");

	}
	
	protected void telaAddCursoPeriodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Coordenadores coord = coorDAO.listaCoordenadoresPeloId(id);
		ArrayList<Cursos> listaCursos = curDAO.listaCurso();
		ArrayList<Periodos> listaPeriodos = perDAO.listaPeriodos();
		request.setAttribute("listaCursos", listaCursos);
		request.setAttribute("listaPeriodos", listaPeriodos);
		request.setAttribute("coordenador", coord);

		RequestDispatcher rd = request.getRequestDispatcher("addNovo.jsp");
		rd.forward(request, response);

	}
	
	protected void addCursoPeriodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Coordenadores coord = new Coordenadores();
		Cursos cursos = new Cursos();
		Periodos per = new Periodos();	
		
		coord.setId(Integer.parseInt(request.getParameter("id")));
		
		//TESTE RECEBIMENTO PARAMETRO
		System.out.println(request.getParameter("id"));

		Integer idOutroCurso = Integer.parseInt(request.getParameter("curso"));

		Integer idOutroPeriodo = Integer.parseInt(request.getParameter("periodo"));
		
		cursos.setId(idOutroCurso);
		per.setId(idOutroPeriodo);
		
		coorDAO.inserirCursoCoordenador(coord.getId(), cursos.getId());
		coorDAO.inserirPeriodoCoordenador(coord.getId(),per.getId());
		
		RequestDispatcher rd = request.getRequestDispatcher("main");
		rd.forward(request, response);
	}
}
