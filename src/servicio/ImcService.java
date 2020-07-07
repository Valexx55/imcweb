package servicio;

import org.apache.log4j.Logger;

import bean.ImcResultado;
import edu.hedima.val.imc.IMC;
import edu.hedima.val.imc.Persona;
import edu.hedima.val.imc.TiposIMC;

public class ImcService {
	
	private Logger log = Logger.getLogger("mylog");
	
	public ImcResultado calcularIMC (Persona p)
	{
		ImcResultado imcResultado = null;
		double imc_double = 0;
		TiposIMC tipo_imc = null;
		String str_imc = null;
		
			imc_double = IMC.calcula(p);
			log.debug("IMC calculado es " + imc_double);
			tipo_imc = TiposIMC.traduceIMC(imc_double);
			log.debug("TIPO IMC calculado es " + tipo_imc);
			str_imc = tipo_imc.toString();
			imcResultado = new ImcResultado(str_imc, imc_double);
		
		return imcResultado;
		
	}

}
