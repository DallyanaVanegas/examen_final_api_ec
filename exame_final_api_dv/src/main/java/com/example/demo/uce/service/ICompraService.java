package com.example.demo.uce.service;

import com.example.demo.uce.repository.modelo.CompraPasaje;

public interface ICompraService {
	
	public void realizarCompra(CompraPasaje compra);
	public void actualizarCompra(Integer numero);
}
