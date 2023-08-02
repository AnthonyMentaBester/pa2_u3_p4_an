package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	
	public void metodo(IPersonaSupplier<String> function)  {
		
	LOG.info("metodo high order" + function.getId());
	
	}
	
	public void acceso(IPersonaConsumer<String> function,String cadena) {
		function.accept(cadena);
	}

}
