package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Override
	public void agregar(CuentaBancaria bancaria) {
		LOG.info("HILO: " + Thread.currentThread().getName());

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(bancaria);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(bancaria);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public void borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminarPorNumero(numero);
	}

	@Override
	public String agregar2(CuentaBancaria bancaria) {
		LOG.info("HILO: " + Thread.currentThread().getName());

		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(bancaria);
		return bancaria.getNumero();
	}

	@Override
	@Async
	public void agrearAsincrono(CuentaBancaria bancaria) {
		LOG.info("HILO: " + Thread.currentThread().getName());

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(bancaria);
	
		
	}

	@Override
	//debe tener la anotacion 
	@Async
	//no podemos retornar directam,ente el string nos 
	//apoyamos de una clase COMPLETABLE FUTURE
	public CompletableFuture<String> agrearAsincrono2(CuentaBancaria bancaria) {
		LOG.info("HILO: " + Thread.currentThread().getName());

		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(bancaria);
		//debo apoyarme tambien en retorno
		return CompletableFuture.completedFuture(bancaria.getNumero());
	}

}
