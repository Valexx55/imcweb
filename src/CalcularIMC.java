

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.hedima.val.imc.IMC;
import edu.hedima.val.imc.Persona;

/**
 * Servlet implementation class CalcularIMC
 */
@WebServlet("/CalcularIMC")
public class CalcularIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcularIMC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO leer el peso y la altura recibidos y devolver el IMC
		//al ser un POST , la info viene en el cuerpo. Hay que leer de ah�
		
		BufferedReader br = request.getReader();
		String persona_json = br.readLine();
		System.out.println("Persona json = " +persona_json);
		System.out.println("TIPO MIME = "+request.getContentType());
		//tengo que pasar de String - JSON a Objeto Persona de JAVA
		//DESERIALIZAR
		//para serializar y deserializar JSON en JAVA se usa Gson
		//Gson es una biblioteca de Google para este menester
		//vamos a pasar de string a persona
		Gson gson = new Gson();
		Persona p = gson.fromJson(persona_json, Persona.class);;
		System.out.println("Peso persona = " +p.getPeso());
		System.out.println("Altura persona = "+ p.getAltura());
		double imc = IMC.calcula(p);
		System.out.println("Imc obtenido = " + imc);
		response.getWriter().append(imc+"");
		
		
	}

}
