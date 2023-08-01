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
		
		//2.- CONSUMER
		
		//Clases 
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer clase: " );
		consumer1.accept("anthoioyn narvaez");
		
		//Lambdas
		IPersonaConsumer<String> consumer2 = cadena -> LOG.info(cadena);
		LOG.info("ConsumerLambda: " );
		consumer2.accept("anthony narvaez2");
		
		//3.- PREDICATE 
		//LAMBDAS 
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo( 8)==0;
		LOG.info("Predicate Lambda: " + predicate1.evaluar(4));
	    
		IPersonaPredicate<Integer> predicate2 = valor -> {
		Integer valor2 = 10;	
		
				valor -= valor + valor2 ;
		if(valor.compareTo( 100)>0) {
			return true;
		}
		else {
			return false;
		}
		
		};
		
		LOG.info("Predicate lambda: " + predicate2.evaluar(95));
		
		
		
		
		IPersonaPredicate<String> predicate3 = caracter -> {
					
			if(caracter.contains("#")) {
				return true;
			}
			else {
				return false;
			}
			
			};
			
			LOG.info("Predicate lambda: " + predicate3.evaluar("#hola"));
			
			IPersonaBIPredicate<String, String> predicate4 = (caracter,texto) -> texto.contains(caracter);
			LOG.info("PredicateBI lambda: " + predicate4.evaluar("#", "hola#"));
		
			//FUNCTION 
			
			//LAMBDAS 
			//el rpimer dato es el que retorna 
			IPersonaFunction<String, Integer> function = numero -> numero.toString();
			LOG.info("Function lambda: " + function.aplicar(8));
			
			IPersonaFunction<String, Integer> function1 = numero -> {
				String valorFinal = numero.toString().concat("valor : ");
				return valorFinal;
			};
			
			
			LOG.info("Function1 lambda: " + function1.aplicar(10));
	
	
			//UNARY OPERATOR 
			//LAMBDA 
			IPersonaUnaryOperator<Integer> unaryOperator = numero -> numero + (numero*2);
			LOG.info("UnarYoPERATOR lambda: " + unaryOperator.aplicar(3));
			
	
			IPersonaUnaryOperatorFunction<Integer> unaryOperator1 = numero -> numero + (numero*2);
			LOG.info("UnaryOperator2 lambda: " + unaryOperator1.aplicar(3));
			
			//Metodos HighOrder o metodos refenciados 
			
			MetodosReferenciados metodos = new MetodosReferenciados();
			//SE EMPLEMENTA CON 2 POUNTOS necesito uno cumpla el conttrato
			//con supplier
			IPersonaSupplier<Integer> supplier = metodos::getID;
			LOG.info("metodo refenciado supplier : " + supplier.getId());
			
			IPersonaConsumer<String> consumer = metodos::aceptar;
			LOG.info("metodo refenciado consumer : ");
			consumer.accept("A");
			
			IPersonaPredicate<String> predicatee = metodos::comparar;
			LOG.info("metodo refenciado predicate : " + predicatee.evaluar("#hola"));
			
			
	
	
	}		
	
	
}
