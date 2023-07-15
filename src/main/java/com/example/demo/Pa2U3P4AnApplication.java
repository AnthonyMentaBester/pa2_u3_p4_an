package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;

@SpringBootApplication
public class Pa2U3P4AnApplication implements CommandLineRunner{

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private HabitacionService habitacionService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Hotel> hot = this.hotelService.buscarInnerJoin();
		for (Hotel hotel : hot) {
			System.out.println(hotel);
			for (Habitacion habi : hotel.getHabitaciones()) {
				System.out.println(habi.getNumero());
			}
		}
		
		System.out.println("JOIN FETCH ");
		List<Hotel> hot1 = this.hotelService.buscarFetchJoin();
		for (Hotel hotel : hot1) {
			System.out.println(hotel);
			for (Habitacion habi : hotel.getHabitaciones()) {
				System.out.println(habi.getNumero());
			}
		}
		List<Habitacion> habis = new ArrayList<>();
		Habitacion  habi = new Habitacion();
		habi.setNumero("23");
		habi.setValor(new BigDecimal(123));
		habis.add(habi);
		
		Hotel hot3 = new Hotel();
		hot3.setDireccion("av las lomas");
		hot3.setNombre("Marriot");
		hot3.setHabitaciones(habis);
		this.hotelService.agregar(hot3);
		/*
		List<Hotel> hot1 = this.hotelService.buscarOuterRightJoin();
		for (Hotel hotel : hot1) {
			System.out.println(hotel);
		}
		
		List<Hotel> hot2 = this.hotelService.buscarLeftRightJoin();
		for (Hotel hotel : hot2) {
			System.out.println(hotel);
		}
		
		List<Habitacion> hot3 = this.habitacionService.buscarHabitacionOuterJoin();
		for (Habitacion habi : hot3) {
			System.out.println(habi);
		}
		
		List<Hotel> hot4 = this.hotelService.buscarOuterFullJoin();
		for (Hotel hotel : hot4) {
			System.out.println(hotel);
		}
		
		List<Hotel> hot5 = this.hotelService.buscarWhereJoin();
		for (Hotel hotel : hot5) {
			System.out.println(hotel);
		}*/
	}

}
