package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements  MatriculaService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	public void crearMatricula(String cedula, List<Materia>) {
		// TODO Auto-generated method stub

		 List<Estudiante> estu = this.estudianteRepository.seleccionar(cedula);
		
		
		Materia mate = new Materia();
		List<Materia> mate = this.materiaRepository;
		
		
	}

	@Override
	public Matricula buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.matriculaRepository.seleccionar(id);
	}

}
