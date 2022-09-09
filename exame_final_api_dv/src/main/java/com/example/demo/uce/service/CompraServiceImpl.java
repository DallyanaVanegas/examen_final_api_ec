package com.example.demo.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.ICompraRepository;
import com.example.demo.uce.repository.modelo.CompraPasaje;

@Service
public class CompraServiceImpl implements ICompraService {

	@Autowired
	private ICompraRepository compraRepository;
	
	@Override
	public void realizarCompra(CompraPasaje compra) {
		this.compraRepository.realizarCompra(compra);	
	}

	@Override
	public void actualizarCompra(Integer numero) {
		CompraPasaje miCompra= this.compraRepository.buscar(numero);
		if(miCompra!=null) {
			miCompra.setEstado("Check-in");
			this.compraRepository.actualizarCompra(miCompra);
		}
		
	}
	

}
