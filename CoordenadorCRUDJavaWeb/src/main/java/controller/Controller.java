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
@WebServlet(urlPatterns = { "/Controller", "/main", "/telaAddCoordenador", "/create" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CoordenadorDAO coorDAO = new CoordenadorDAO();
	Coordenadores coor = new Coordenadores();
	CursoDAO curDAO = new CursoDAO();
	PeriodoDAO perDAO = new PeriodoDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			acessarListaCoordenador(request, response);
		} else if (action.equals("/telaAddCoordenador")) {
			addCoordenador(request, response);
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
}
