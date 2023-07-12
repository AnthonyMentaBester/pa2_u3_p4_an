package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements HabitacionRepository {

    @PersistenceContext
	private EntityManager entitymanager;

    @Override
    public void insertar(Habitacion habitacion) {
        // TODO Auto-generated method stub
        this.entitymanager.persist(habitacion);
    }

    @Override
    public void actualizar(Habitacion habitacion) {
        // TODO Auto-generated method stub
        this.entitymanager.merge(habitacion);
    }

    @Override
    public Habitacion seleccionar(Integer id) {
        // TODO Auto-generated method stub
        return this.entitymanager.find(Habitacion.class,id);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        Habitacion habitacion = this.seleccionar(id);
        this.entitymanager.remove(habitacion);
    }
    
    @Override
	public List<Habitacion> seleccionarHabitacionOuterJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery = this.entitymanager.createQuery("SELECT h FROM Habitacion h LEFT JOIN h.hotel ha",Habitacion.class);
		
		return myQuery.getResultList();
	}
    

}