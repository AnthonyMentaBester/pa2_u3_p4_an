package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;
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
	
	@Autowired
	private ITransferenciaService transferenciaService;

	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	System.out.println("Main: " + TransactionSynchronizationManager.isActualTransactionActive()); 
	Propietario prop = new Propietario();
	prop.setNombre("Juan");
	prop.setApellido("narvaez");
	prop.setCedula("17223214234");
	
	this.iPropietarioService.agregar(prop);
	}

	

}
