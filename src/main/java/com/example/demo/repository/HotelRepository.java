package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelRepository {
    public void insertar(Hotel hotel);
	public void actualizar(Hotel hotel);
	public Hotel seleccionar(Integer id);
	public void eliminar(Integer id); 
	//INNER
	public List<Hotel> seleccionarInnerJoin();
	//OUTER
	public List<Hotel> seleccionerOuterRightJoin();
	public List<Hotel> seleccionerLeftRightJoin();
	
	
	public List<Hotel> seleccionerOuterFullJoin();
	
	//WHERE
	public List<Hotel> seleccionarWhereJoin();
	
	

}