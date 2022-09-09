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
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="clie_id")
	private Integer id;
	@Column(name="clie_nombre")
	private String nombre;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente",fetch = FetchType.LAZY)
	private List<CompraPasaje> compraPasaje= new ArrayList<>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<CompraPasaje> getCompraPasaje() {
		return compraPasaje;
	}


	public void setCompraPasaje(List<CompraPasaje> compraPasaje) {
		this.compraPasaje = compraPasaje;
	}
	
	
	
	
	
	

}
