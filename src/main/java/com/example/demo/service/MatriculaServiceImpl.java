package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Semestre;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Autowired
	private MateriaRepository materiaRepository;

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	public void crearMatricula(String cedula, List<String> listCodigos) {
		// TODO Auto-generated method stub

		Estudiante estudiante = this.estudianteRepository.seleccionar(cedula);
		
		List<Matricula> matriculas = new ArrayList<>();
		Matricula mat = new Matricula();
		mat.setNombre("ordinaria");
		
		mat.setEstado("matriculado");
		mat.setEstudiante(estudiante);
		mat.setFecha(LocalDate.now());
		estudiante.setMatriculas(matriculas);
		this.matriculaRepository.insertar(mat);
		
		
		Semestre sem = new Semestre();
		sem.setNumSemestre("4to");
		sem.setNumero("primera");
		sem.setTipo("precencial");
		
		List<Materia> materias = new ArrayList<>();
		Materia m = new Materia();
		m.setNombre("lenguaje");
		m.setCodigo("1");
		m.setHoras("3");
		m.setSemestre(sem);

		materias.add(m);
		Materia m1 = new Materia();
		m1.setNombre("matematica");
		m1.setCodigo("2");
		m1.setHoras("4");
		m1.setSemestre(sem);
		materias.add(m1);
		
		Materia m2 = new Materia();
		m2.setNombre("Calculo");
		m2.setCodigo("3");
		m2.setHoras("2");
		m2.setSemestre(sem);
		materias.add(m2);
		
		m.setMatriculas(matriculas);
		this.materiaRepository.insertar(m);

	}

	@Override
	public Matricula buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.matriculaRepository.seleccionar(id);
	}

}