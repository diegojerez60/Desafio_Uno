package cl.diegojerez.previred.desafio.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.diegojerez.previred.desafio.controller.PeriodoController;
import cl.diegojerez.previred.desafio.models.Periodo;

/**
*
* @author diegojerez32@gmail.com
*/
@Service
public class PeriodoService implements IPeriodoService {
	
	private static Logger log = LoggerFactory.getLogger(PeriodoController.class);
	
    @Value("${dir.service}")
    private String dirService;
	
	@Autowired
	private RestTemplate clienteRest;
	
	
	/**
	 * Genera un Objeto periodo, con todos los rangos de fechas
	 * faltantes entre las fecha creacion y fin (inclusives)
	 * 
	 * @return
	 */
	@Override
	public Periodo periodos() {
		
		log.info("Entrando al metodo listar Periodos Faltantes");
		
		Optional<Periodo> periodo = Optional.empty();
		
		try {
			
			periodo = Optional.of(clienteRest.getForObject(dirService, Periodo.class));
			
			Optional<LocalDate> fechaInicio = Optional.of(periodo.get().getFechaCreacion());
			Optional<LocalDate> fechaTermino = Optional.of(periodo.get().getFechaFin());
			List<LocalDate> fechas = periodo.get().getFechas();
	        
	        while( ( fechaInicio.get().isBefore(fechaTermino.get()) || fechaInicio.get().isEqual(fechaTermino.get()) ) ) {
	        	if(!fechas.contains(fechaInicio.get()))
	        		periodo.get().addFechasFaltantesItem(fechaInicio.get());
	        	fechaInicio = Optional.of(fechaInicio.get().plusMonths(1));
	        }
		} catch (Exception e) {
			log.error( String.format("[periodos] Error en el metodo se procede a ejecutar metodo alternativo. Error: %s", e) );
		}
	
		log.info( String.format("Finalizando el metodo listar Periodos Faltantes. Cantidad elementos faltantes: %s", periodo.get().getFechasFaltantes().size()) );
		
		return periodo.get();
	}

}
