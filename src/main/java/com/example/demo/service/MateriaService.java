package com.example.demo.service;

import com.example.demo.repository.modelo.Materia;

public interface MateriaService {
	public void agregar(Materia materia);
	public Materia buscar(Integer id);

}
