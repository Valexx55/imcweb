package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saludo
 */
@WebServlet("/Saludo") // mapping-correspondecia
public class Saludo extends HttpServlet {
	//IoC Inversion de Control --> new lo hace el otra app
	//apache tomacta hace el new de Saludo, yo no--> eso es IOC
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Saludo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// LA PETICIÓN ES DE CONSULTA --GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtener el idioma y devolver el saludo en ese idioma
		String idioma = request.getParameter("idioma");
		System.out.println("Idioma recibido (rx) " + idioma);
		String saludo = null;
		switch (idioma) {
		case "fr":
			saludo = "Salut";
			break;
		case "es":
			saludo = "Hola";
			break;
		case "en":
			saludo = "Hello";
			break;
		case "it":
			saludo = "Ciao";
			break;

		default:  //por defecto ponemos español
				saludo = "Hola";
			break;
		}

		response.getWriter().append(saludo);
	}
//http://localhost:8080/imcweb/Saludo?idioma=fr //HEADER
	//en las peticiones GET el cuerpo va vacío!!!
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// LA PETICIÓN TRAE DATOS EN EL CUERPO -- POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//VOLVEMOS A LAS 11:50 :D

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
