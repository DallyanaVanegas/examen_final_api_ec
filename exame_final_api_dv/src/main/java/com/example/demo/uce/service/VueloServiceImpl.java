package com.example.demo.uce.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.controller.DTO.ReservaDTO;
import com.example.demo.uce.controller.DTO.VueloDTO;
import com.example.demo.uce.repository.IVueloRepository;
import com.example.demo.uce.repository.modelo.Cliente;
import com.example.demo.uce.repository.modelo.CompraPasaje;
import com.example.demo.uce.repository.modelo.Vuelo;

@Service
public class VueloServiceImpl implements IVueloService {
	
	@Autowired
	private IVueloRepository vueloRepository;
	
	@Autowired
	private ICompraService compraService;
	
	@Autowired
	private IClienteService clienteService;

	@Override
	public List<VueloDTO> buscarVuelDisp(String origen, String destino, String fechaVuelo) {
		List<VueloDTO> miLista= new ArrayList<VueloDTO>();
		VueloDTO miVuelo= new VueloDTO();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		//LocalDate date= LocalDate.parse(fechaVuelo,formatter);
		
		List<Vuelo> listaR = vueloRepository.buscarVuelDisp(origen, destino, fechaVuelo);
		
		for(Vuelo vuelo : listaR) {
			if(vuelo.getEstado().equalsIgnoreCase("Disponible")) {
				miVuelo.setNumero(vuelo.getNumero());
				miVuelo.setOrigen(vuelo.getOrigen());
				miVuelo.setDestino(vuelo.getDestino());
				miVuelo.setCategoria(vuelo.getCategoria());
				miVuelo.setNombre(vuelo.getAvion().getNombre());
				miVuelo.setValorAsiento(vuelo.getValorAsiento());
				
				miLista.add(miVuelo);
			}
		}
		return miLista;
	}

	@Override
	public String reserva(ReservaDTO res) {
		CompraPasaje compra= new CompraPasaje();
		Cliente miCliente = new Cliente();
		Vuelo miVuelo = vueloRepository.buscarVueloPorNumero(res.getNumero());
		String sol="Vuelo no disponible";
		if(miVuelo==null) {
			return sol="No existe el vuelo numero: " +res.getNumero();
		}
		
		if(miVuelo.getEstado().equalsIgnoreCase("Disponible")) {
			Integer disponibles = miVuelo.getAsientosDisponibles();
			
			if(res.getAsientosCompra()<=disponibles) {
				
				LocalDate todaysDate = LocalDate.now();
				compra.setFechaCompra(todaysDate);
				compra.setNumeroTarjeta(res.getNumTarjeta());
				compra.setEstado("Reservado");
				compra.setAsientosComprados(res.getAsientosCompra());
				compra.setNumero(res.getNumero());
				
				miCliente.setNombre(res.getNombre());
				this.clienteService.crearCliente(miCliente);
				
				compra.setCliente(miCliente); 
				compra.setVuelo(miVuelo);
				this.compraService.realizarCompra(compra);
				
				//cambio asientos disponibles del vuelo
				miVuelo.setAsientosDisponibles(disponibles-res.getAsientosCompra());
				//cambio disponibilidad 
				if(miVuelo.getAsientosDisponibles()==0) {
					miVuelo.setCategoria("No disponible");
				}
				//actualizo vuelo
				this.actualizarVuelo(miVuelo);	
				
				sol="Compra reservada con exito";
			}else {
				sol="No hay tantos asientos disponibles";
			}
		}
		return sol;
		
	}

	@Override
	public void actualizarVuelo(Vuelo vuelo) {
		this.vueloRepository.actualizarVuelo(vuelo);
		
	}

	@Override
	public String buscarVueloPorNumero(Integer numero) {
		Vuelo miVuelo = vueloRepository.buscarVueloPorNumero(numero);
		String sol="Vuelo no disponible";
		if(miVuelo==null) {
			return sol="No existe el vuelo numero: " +numero ;
		}
		if(miVuelo.getEstado().equalsIgnoreCase("Disponible")) {
			Integer ocupados= miVuelo.getAvion().getCapacidadAsientos()-miVuelo.getAsientosDisponibles();
			Integer disponibles = miVuelo.getAsientosDisponibles();
			sol="Para el vuelo numero: " +numero+" hay: Asientos ocupados: " +ocupados+ " Asientos disponibles: " +disponibles;
		}
		return sol;
	}

}
