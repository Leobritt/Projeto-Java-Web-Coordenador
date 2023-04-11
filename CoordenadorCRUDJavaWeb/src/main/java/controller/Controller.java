package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoordenadorDAO;
import dao.CursoDAO;
import dao.PeriodoDAO;
import model.Coordenadores;
import model.Cursos;
import model.Periodos;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/telaAddCoordenador", "/create", "/editar" })
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
			editarCoordenador(request, response);
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

		response.sendRedirect("/main");

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

	protected void editarCoordenador(HttpServletRequest request, HttpServletResponse response)
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

}
