

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LetraDni
 */
@WebServlet("/LetraDni")
public class LetraDni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LetraDni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO solucion para letradeni
		System.out.println("llamando a Get LetraDNI");
		String numero_rx = request.getParameter("numerodni");
		System.out.println("Numero rx = " + numero_rx);
		//casting parseo para pasar de String a int
		int numero_dni = Integer.parseInt(numero_rx);
		Dni dni = new Dni(numero_dni);
		char letra_dni = dni.calcularLetra();
		System.out.println("Letra calcuada = " + letra_dni);
		
		response.getWriter().append(letra_dni);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
