package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Provincia;
import com.example.demo.repository.modelo.Semestre;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.MateriaService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U3P4AnApplication implements CommandLineRunner{

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriaService materiaService;

	@Autowired
	private MatriculaService matriculaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Provincia prov = new Provincia();
		prov.setCapital("Pichincha");
		prov.setCiudad("Quito");
		prov.setRegion("Sierra");
			
	List<Estudiante> estudiantes = new ArrayList<>();
	Estudiante e = new Estudiante();
	e.setApellido("NARVAEZ");
	e.setCedula("1719954370");
	e.setFacultad("Ciencias aplicadas");
	e.setProvincia(prov);
	e.setNombre("Anthony");
	
	estudiantes.add(e);
	this.estudianteService.agregar(e);
	
	
	
	List<String> codigos = new ArrayList<>();
	codigos.add("1");
	codigos.add("2");
	
	this.matriculaService.crearMatricula("1719954370", codigos);
	
	}

	

}
