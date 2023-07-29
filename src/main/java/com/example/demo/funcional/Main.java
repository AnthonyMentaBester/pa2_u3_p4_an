package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		IPersona per = new PersonaImpl();
		per.caminar();

		// 1.- SUPPLIER

		// CLASES:
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		// la buena practica es usar un logger enves de sysout y dentro de spring es
		// slf4j

		LOG.info("n Supplier clase: " + supplier1.getId());
		
		
		//LAMBDAS 
		//sino recibe el supplier le pongo solo parentesis
		//si solo existe una expresion no requiere el return
		IPersonaSupplier<String> supplier2 = ()-> "1719954370";
		LOG.info("n Supplier lambda: " + supplier2.getId());

		IPersonaSupplier<String> supplier3 = ()-> {
			String cedula = "1719954370";
		cedula = cedula + "zzzzzz";
		return cedula;
		};
		LOG.info("n Supplier lambda: " + supplier3.getId());
	}
}
