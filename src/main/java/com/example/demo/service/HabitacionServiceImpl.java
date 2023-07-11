package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HabitacionRepository;
import com.example.demo.repository.modelo.Habitacion;


@Service
public class HabitacionServiceImpl implements HabitacionService{

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public void agregar(Habitacion habitacion) {
        // TODO Auto-generated method stub
        this.habitacionRepository.insertar(habitacion);
    }

    @Override
    public void actualizar(Habitacion habitacion) {
        // TODO Auto-generated method stub
        this.habitacionRepository.actualizar(habitacion);
    }

    @Override
    public Habitacion buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.habitacionRepository.seleccionar(id);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.habitacionRepository.eliminar(id);
    }
    

    
}