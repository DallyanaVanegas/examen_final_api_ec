package com.example.demo.uce.repository;

import java.util.List;

import com.example.demo.uce.repository.modelo.Vuelo;

public interface IVueloRepository {
	
	public List<Vuelo> buscarVuelDisp(String origen, String destino, String fechaVuelo);
	public Vuelo buscarVueloPorNumero(Integer numero);
	public void actualizarVuelo(Vuelo vuelo);

}
