package com.example.demo.uce.repository.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="avion")
public class Avion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="avio_id")
	private Integer id;
	@Column(name="avio_capacidad_asientos")
	private Integer capacidadAsientos;
	@Column(name="vuel_nombre_avion")
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "avion",fetch = FetchType.LAZY)
	private List<Vuelo> compraPasaje= new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidadAsientos() {
		return capacidadAsientos;
	}

	public void setCapacidadAsientos(Integer capacidadAsientos) {
		this.capacidadAsientos = capacidadAsientos;
	}

	public List<Vuelo> getCompraPasaje() {
		return compraPasaje;
	}

	public void setCompraPasaje(List<Vuelo> compraPasaje) {
		this.compraPasaje = compraPasaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

	
}
