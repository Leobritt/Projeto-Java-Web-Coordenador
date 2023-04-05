package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoordenadorDAO;
import model.Coordenadores;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/telaAddCoordenador" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CoordenadorDAO coorDAO = new CoordenadorDAO();
	Coordenadores coor = new Coordenadores();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			acessarListaCoordenador(request, response);
		}
	}

	protected void acessarListaCoordenador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Coordenadores> lista = coorDAO.listaCoordenadores();
		lista.forEach(System.out::println);
		
	}

}
