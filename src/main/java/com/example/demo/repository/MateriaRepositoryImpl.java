package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public List<Materia> seleccionar(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entitymanager.createQuery("SELECT m FROM Materia m JOIN FETCH m.matriculas ,a",Materia.class);
		
		
		return myQuery.getResultList();
	}

}
