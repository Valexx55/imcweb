package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import bean.ImcResultado;
import edu.hedima.val.imc.IMC;
import edu.hedima.val.imc.Persona;
import edu.hedima.val.imc.TiposIMC;
import servicio.ImcService;

/**
 * Servlet implementation class CalcularIMC
 */
@WebServlet("/CalcularIMC")
public class CalcularIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger("mylog");
	private ImcService imcService;

	private List<Persona> lp = new ArrayList<Persona>();

	// SCOPE O ÁMBITO --> CUÁNTO TIEMPO VIVE UNA VARIABLE EN EL SERVIDOR
	// REQUEST --> CADA VE QUE LLAMO SE CREA Y SE DESTRUYE
	// SESIÓN --> DURA LO QUE DURA LA SESIÓN
	// CONTEXTO --> DURA LO QUE DURE LA APLICACIÓN

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		imcService = new ImcService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcularIMC() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// tengo que pasar de String - JSON a Objeto Persona de JAVA
	// DESERIALIZAR
	// para serializar y deserializar JSON en JAVA se usa Gson
	// Gson es una biblioteca de Google para este menester
	// vamos a pasar de string a persona
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO leer el peso y la altura recibidos y devolver el IMC
		// al ser un POST , la info viene en el cuerpo. Hay que leer de ahí
		Persona p = null;
		int status_http = 0;
		log.debug("Ha entrado CalcularIMC post");
		// recibo la petición
		BufferedReader br = request.getReader();
		String persona_json = br.readLine();
		log.debug("Datos rx " + persona_json);
		Gson gson = new Gson();
		try {

			p = gson.fromJson(persona_json, Persona.class);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			log.error("error al deserializar la persona json", e);
			status_http = HttpURLConnection.HTTP_BAD_REQUEST;
		}
		if (status_http == 0) {
			// llamo al servicio
			ImcResultado imcResultado = imcService.calcularIMC(p);

			// devuelvo la respuesta
			String json_resultado = gson.toJson(imcResultado);
			log.debug("Datos tx " + json_resultado);
			response.getWriter().append(json_resultado);// escribo el JSON en el cuerpo
		} else {
			response.setStatus(status_http);//devuelvo un 400
		}

	}

}
