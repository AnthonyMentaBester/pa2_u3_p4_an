package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepository propietarioRepository;
	
	@Autowired
	private PruebaService pruebaService;

	@Override
	//@Transactional
	public void agregar(Propietario propietario) {
		// TODO Auto-generated method stub
		System.out.println("Service: " + TransactionSynchronizationManager.isActualTransactionActive());
		
		//this.propietarioRepository.insertar(propietario);
		//this.pruebaService.prueba();
		//this.pruebaService.prueba2();
		//this.pruebaService.pruebaSupports();
		//this.pruebaService.pruebaNoSupports();
		//this.pruebaService.required();
		this.pruebaService.requiredNew();
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepository.actualizar(propietario);
	}

	@Override
	public Propietario buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.propietarioRepository.seleccionarPorCedula(cedula);
		
	}

	@Override
	public void borrarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		this.propietarioRepository.eliminarPorCedula(cedula);
	}
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println("Metodo: " + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba");
	}
	
	
}
