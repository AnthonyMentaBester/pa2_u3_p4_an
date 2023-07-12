package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelService {
    public void agregar(Hotel hotel);
	public void actualizar(Hotel hotel);
	public Hotel buscar(Integer id);
	public void borrar(Integer id); 
	
	//inner
	public List<Hotel> buscarInnerJoin();
    
	//outer
	public List<Hotel> buscarOuterRightJoin();
	public List<Hotel> buscarLeftRightJoin();
	
	
	
	public List<Hotel> buscarOuterFullJoin();
	
	//WHERE
	public List<Hotel> buscarWhereJoin();
}