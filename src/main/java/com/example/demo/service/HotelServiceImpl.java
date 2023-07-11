package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void agregar(Hotel hotel) {
        // TODO Auto-generated method stub
        this.hotelRepository.insertar(hotel);
    }

    @Override
    public void actualizar(Hotel hotel) {
        // TODO Auto-generated method stub
        this.hotelRepository.actualizar(hotel);
    }

    @Override
    public Hotel buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.hotelRepository.seleccionar(id);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.hotelRepository.eliminar(id);
    }

	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarInnerJoin();
	}
    
}