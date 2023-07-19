package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface MatriculaService {
	
	public void crearMatricula(String cedula,List<String> codigo);

	public Matricula buscar(Integer id);

}
