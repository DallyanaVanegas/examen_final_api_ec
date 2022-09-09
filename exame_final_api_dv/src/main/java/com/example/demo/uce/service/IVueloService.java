package com.example.demo.uce.service;

import java.util.List;

import com.example.demo.uce.controller.DTO.ReservaDTO;
import com.example.demo.uce.controller.DTO.VueloDTO;
import com.example.demo.uce.repository.modelo.Vuelo;

public interface IVueloService {
	
	public List<VueloDTO> buscarVuelDisp(String origen, String destino, String fechaVuelo);
	public String reserva(ReservaDTO res);
	public String buscarVueloPorNumero(Integer numero);
	public void actualizarVuelo(Vuelo vuelo);
	
}
