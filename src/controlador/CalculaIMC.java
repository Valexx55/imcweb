package controlador;


import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hedima.val.imc.EntradaSalida;
import edu.hedima.val.imc.IMC;
import edu.hedima.val.imc.Persona;

/**
 * Servlet implementation class CalculaIMC
 */
@WebServlet("/CalculaIMC")
public class CalculaIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculaIMC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//jar JAVA ARCHIVE - LIBRERÍAS JAVA BIBLIOTECAS
		//usar el jar importado 
		Persona persona = new Persona(90, 2);
		double imc_n = IMC.calcula(persona);
		//System.out.println(imc_n);
		response.getWriter().append("Su imc es "+ imc_n);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		BufferedReader br = request.getReader();
		System.out.println(br.readLine());
		response.getWriter().append("22");
	}

}
