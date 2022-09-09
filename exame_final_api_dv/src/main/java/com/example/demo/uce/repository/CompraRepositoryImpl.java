package com.example.demo.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.CompraPasaje;

@Repository
@Transactional
public class CompraRepositoryImpl implements ICompraRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void realizarCompra(CompraPasaje compra) {
		this.em.persist(compra);
	}

	@Override
	public void actualizarCompra(CompraPasaje compra) {
		this.em.merge(compra);
	}

	@Override
	public CompraPasaje buscar(Integer numero) {
		TypedQuery<CompraPasaje > myQuery = this.em.createQuery("SELECT e FROM CompraPasaje  e WHERE e.numero= : numero", CompraPasaje .class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}


	

}
