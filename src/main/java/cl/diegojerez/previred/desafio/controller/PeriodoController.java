package cl.diegojerez.previred.desafio.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cl.diegojerez.previred.desafio.models.Periodo;
import cl.diegojerez.previred.desafio.service.IPeriodoService;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author diegojerez32@gmail.com
 *
 */
@RestController
@RequestMapping("/periodos")
public class PeriodoController {

	@Autowired
	private IPeriodoService periodoService;
	
	@ApiOperation(value = "Consige todos los periodos faltantes", response = Periodo.class)
	@HystrixCommand( fallbackMethod = "getPeriodosAlternativo")
	@GetMapping("/listarFaltantes")
	public ResponseEntity<Periodo> getPeriodos() {
		return new ResponseEntity<Periodo>(periodoService.periodos(), HttpStatus.OK);
	}
	
	/**
	 * Implementacion de Hystrix con un metodo alternativo, en caso de haber un problema
	 * con hilo principal y evitar errores en cascada
	 * 
	 * @return
	 */
	public ResponseEntity<Periodo> getPeriodosAlternativo() {
		
		Periodo per = new Periodo();
		
		per.setId(0l);
		per.setFechaFin(LocalDate.now());
		per.setFechaCreacion(LocalDate.now());
		per.setFechas(new ArrayList<LocalDate>());
		per.setFechasFaltantes(new ArrayList<LocalDate>());
		
		return  new ResponseEntity<Periodo>(per, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
