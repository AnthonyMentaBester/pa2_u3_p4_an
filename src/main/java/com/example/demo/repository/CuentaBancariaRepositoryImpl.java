package com.example.demo.repository;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CuentaBancaria bancaria) {
		LOG.info("HILO: " + Thread.currentThread().getName());
		//logica que demora 1 segundo asumiendo hace operaciones
		
		
		// TODO Auto-generated method stub
		this.entityManager.persist(bancaria);
	}

	@Override
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(bancaria);
	}

	@Override
	public CuentaBancaria seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CuentaBancaria> myQuery = this.entityManager
				.createQuery("SELECT cb FROM CuentaBancaria cb WHERE cb.numero = :datoNumero", CuentaBancaria.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	public void eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		CuentaBancaria bancaria = this.seleccionarPorNumero(numero);
		this.entityManager.remove(bancaria);
	}

}
