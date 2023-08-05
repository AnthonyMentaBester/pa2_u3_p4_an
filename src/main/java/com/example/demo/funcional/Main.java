package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

		// LAMBDAS
		// sino recibe el supplier le pongo solo parentesis
		// si solo existe una expresion no requiere el return
		IPersonaSupplier<String> supplier2 = () -> "1719954370";
		LOG.info("n Supplier lambda: " + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1719954370";
			cedula = cedula + "zzzzzz";
			return cedula;
		};
		LOG.info("n Supplier lambda: " + supplier3.getId());

		// 2.- CONSUMER

		// Clases
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer clase: ");
		consumer1.accept("anthoioyn narvaez");

		// Lambdas
		IPersonaConsumer<String> consumer2 = cadena -> LOG.info(cadena);
		LOG.info("ConsumerLambda: ");
		consumer2.accept("anthony narvaez2");

		// 3.- PREDICATE
		// LAMBDAS
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("Predicate Lambda: " + predicate1.evaluar(4));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;

			valor -= valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;
			} else {
				return false;
			}

		};

		LOG.info("Predicate lambda: " + predicate2.evaluar(95));

		IPersonaPredicate<String> predicate3 = caracter -> {

			if (caracter.contains("#")) {
				return true;
			} else {
				return false;
			}

		};

		LOG.info("Predicate lambda: " + predicate3.evaluar("#hola"));

		IPersonaBIPredicate<String, String> predicate4 = (caracter, texto) -> texto.contains(caracter);
		LOG.info("PredicateBI lambda: " + predicate4.evaluar("#", "hola#"));

		// FUNCTION

		// LAMBDAS
		// el rpimer dato es el que retorna
		IPersonaFunction<String, Integer> function = numero -> numero.toString();
		LOG.info("Function lambda: " + function.aplicar(8));

		IPersonaFunction<String, Integer> function1 = numero -> {
			String valorFinal = numero.toString().concat("valor : ");
			return valorFinal;
		};

		LOG.info("Function1 lambda: " + function1.aplicar(10));

		// UNARY OPERATOR
		// LAMBDA
		IPersonaUnaryOperator<Integer> unaryOperator = numero -> numero + (numero * 2);
		LOG.info("UnarYoPERATOR lambda: " + unaryOperator.aplicar(3));

		IPersonaUnaryOperatorFunction<Integer> unaryOperator1 = numero -> numero + (numero * 2);
		LOG.info("UnaryOperator2 lambda: " + unaryOperator1.aplicar(3));

		// Metodos HighOrder o metodos refenciados

		MetodosReferenciados metodos = new MetodosReferenciados();
		// SE EMPLEMENTA CON 2 POUNTOS necesito uno cumpla el conttrato
		// con supplier
		IPersonaSupplier<Integer> supplier = MetodosReferenciados::getID;
		LOG.info("metodo refenciado supplier : " + supplier.getId());

		IPersonaConsumer<String> consumer = MetodosReferenciados::aceptar;
		LOG.info("metodo refenciado consumer : ");
		consumer.accept("A");

		IPersonaPredicate<String> predicatee = metodos::comparar;
		LOG.info("metodo refenciado predicate : " + predicatee.evaluar("#hola"));

		// METODOS HIGH ORDER

		MetodosHighOrder highOrder = new MetodosHighOrder();
		// clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();

		highOrder.metodo(supplierHO);
		// lambdas
		highOrder.metodo(() -> "1719954370HO");

		// metodos referenciados
		highOrder.metodo(MetodosReferenciados::getIdHO);

		IPersonaConsumer<String> consumerHO = new PersonaConsumerImpl();
		// clases
		highOrder.acceso(new PersonaConsumerImpl(), "clase consumer");
		// lambdas
		highOrder.acceso(cadena -> {
			LOG.info("cadena");
		}, "consumer");

		highOrder.acceso(MetodosReferenciados::aceptar, "consumer");

		// programacion funcional java o interfaces funcionales
		// JAVA
		// 1.- SUPPLIER

		Stream<String> lista = Stream.generate(() -> "1719954370").limit(10);
		lista.forEach(cadena -> LOG.info(cadena));// como ya aprendi hay consumer del for each
		LOG.info("prueba" + lista);// asi no porque imprimer la direccion

		// 2.- CONSUMER
		List<Integer> listaNum = Arrays.asList(12, 2, 4, 6, 2, 45, 6);
		listaNum.forEach(cadena -> {
			LOG.info("prueba consumer: " + cadena);
		});

		// 3.- PREDICATE
		List<Integer> listaNum1 = Arrays.asList(12, 2, 4, 6, 6, 21, 5, 73, 4, 5, 5, 9);
		Stream<Integer> listaFinal = listaNum1.stream().filter(numero -> numero >= 5);

		listaFinal.forEach(numero -> LOG.info("valor: " + numero));

		// 4.- FUNCTION
		List<Integer> listaNum2 = Arrays.asList(12, 2, 4, 6, 6, 21, 5, 73, 4, 5, 5, 9);
		Stream<String> listaCambiada = listaNum2.stream().map(numero2 -> "N:" + numero2);
		listaCambiada.forEach(cadena -> LOG.info(cadena));

		// 5.- Unary Operator
		List<Integer> listaNum3 = Arrays.asList(12, 2, 4, 6, 6, 21, 5, 73, 4, 5, 5, 9);
		Stream<Integer> listaCambiada2 = listaNum3.stream().map(numero -> {

			Integer num = 10;
			num = numero + num;
			return num;
		});

		listaCambiada2.forEach(cadena -> LOG.info(cadena.toString()));

	}

}
