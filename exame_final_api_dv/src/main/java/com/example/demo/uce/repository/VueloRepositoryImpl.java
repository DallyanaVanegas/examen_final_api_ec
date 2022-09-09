package com.example.demo.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepositoryImpl  implements IVueloRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Vuelo> buscarVuelDisp(String origen, String destino, String fechaVuelo) {
		TypedQuery<Vuelo> myQuery = this.em.createQuery("SELECT e FROM Vuelo e WHERE "
				+ "e.origen= :origen and e.destino= :destino and e.fechaVuelo= :fechaVuelo", Vuelo.class);
		myQuery.setParameter("origen",origen);
		myQuery.setParameter("destino",destino);
		myQuery.setParameter("fechaVuelo",fechaVuelo);
		return myQuery.getResultList();
	}
	
	@Override
	public Vuelo buscarVueloPorNumero(Integer numero) {
		return this.em.find(Vuelo.class, numero);
	}

	@Override
	public void actualizarVuelo(Vuelo vuelo) {
		this.em.merge(vuelo);
	}

	
}
