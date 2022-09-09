package com.example.demo.uce.repository.modelo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="compra_pasaje")
public class CompraPasaje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="copa_id")
	private Integer id;
	@Column(name="copa_numero")
	private Integer numero;
	@Column(name="copa_fecha_compra")
	private LocalDate fechaCompra;
	@Column(name="copa_numero_tarjeta")
	private String numeroTarjeta;
	@Column(name="copa_cantidad_asientos_comprados")
	private Integer asientosComprados;
	@Column(name="copa_estado")
	private String estado;
	
	@JsonIgnore
	@JoinColumn(name = "clie_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@JsonIgnore
	@JoinColumn(name = "vuel_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Vuelo vuelo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Integer getAsientosComprados() {
		return asientosComprados;
	}

	public void setAsientosComprados(Integer asientosComprados) {
		this.asientosComprados = asientosComprados;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	
	
	
	
	
}
