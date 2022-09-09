package com.example.demo.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.controller.DTO.ReservaDTO;
import com.example.demo.uce.controller.DTO.VueloDTO;
import com.example.demo.uce.repository.modelo.Vuelo;
import com.example.demo.uce.service.IVueloService;

@RestController
@RequestMapping("/vuelos")
@CrossOrigin("http://localhost:8080")
public class VueloController {
	
	@Autowired
	private IVueloService vueloService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VueloDTO> buscar(@RequestParam(value = "ori") String origen,@RequestParam(value = "des") String destino , @RequestParam(value = "fec") String fecha) {
		List<VueloDTO> vuel = this.vueloService.buscarVuelDisp(origen, destino, fecha);
		return vuel;
	}
	
	@GetMapping(path = "/{numVuelo}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String buscar(@PathVariable("numVuelo") Integer numero) {
		return this.vueloService.buscarVueloPorNumero(numero);
	}
	
	@PostMapping(consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public String crear(@RequestBody ReservaDTO res) {
		return this.vueloService.reserva(res);
		
		
	}
	
	
	
	
	
	

}
