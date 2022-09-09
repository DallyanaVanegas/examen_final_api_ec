package com.example.demo.uce.repository;


import com.example.demo.uce.repository.modelo.CompraPasaje;

public interface ICompraRepository {
	
	public void realizarCompra(CompraPasaje compra);
	public void actualizarCompra(CompraPasaje compra);
	public CompraPasaje buscar(Integer numero);

}
