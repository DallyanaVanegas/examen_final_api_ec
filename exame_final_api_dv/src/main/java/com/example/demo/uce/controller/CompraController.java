package com.example.demo.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.uce.service.ICompraService;
import com.example.demo.uce.service.IVueloService;


@RequestMapping("/compras")
@CrossOrigin("http://localhost:8080")
@RestController
public class CompraController {
	
	@Autowired
	private ICompraService compraService;
	
	@Autowired
	private IVueloService vueloService;
	
	@GetMapping(path = "/{numCompra}",produces = MediaType.APPLICATION_JSON_VALUE)
	public void buscar(@PathVariable("numCompra") Integer numero) {
		this.compraService.actualizarCompra(numero);
	}
	
}
