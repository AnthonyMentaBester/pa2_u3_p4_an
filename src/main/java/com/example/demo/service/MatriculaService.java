package com.example.demo.service;

import com.example.demo.repository.modelo.Matricula;

public interface MatriculaService {
	
	public void crearMatricula(Matricula matricula);

	public Matricula buscar(Integer id);

}
