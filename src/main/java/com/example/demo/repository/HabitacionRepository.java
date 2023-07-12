package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;


public interface HabitacionRepository {
    public void insertar(Habitacion habitacion);
	public void actualizar(Habitacion habitacion);
	public Habitacion seleccionar(Integer id);
	public void eliminar(Integer id); 
	
	public List<Habitacion> seleccionarHabitacionOuterJoin();
	
	

}