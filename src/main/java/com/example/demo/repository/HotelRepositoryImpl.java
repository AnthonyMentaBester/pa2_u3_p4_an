package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements HotelRepository {

    @PersistenceContext
	private EntityManager entitymanager;

    @Override
    public void insertar(Hotel hotel) {
        // TODO Auto-generated method stub
        this.entitymanager.persist(hotel);
    }

    @Override
    public void actualizar(Hotel hotel) {
        // TODO Auto-generated method stub
        this.entitymanager.merge(hotel);
    }

    @Override
    public Hotel seleccionar(Integer id) {
        // TODO Auto-generated method stub
    	Hotel hot = this.entitymanager.find(Hotel.class,id);
        hot.getHabitaciones().size();
        hot.getDireccion();
        return  hot;
              
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        Hotel hotel = this.seleccionar(id);
        this.entitymanager.remove(hotel);
        //this.entitymanager.remove(this.seleccionar(id));    
        }

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		// TODO Auto-generated method stub
		//select * from hotel h join habitacion ha on h.hot_id = ha.habi_id_hotel
		//pone onde hago la seleccion del atributo
		//SELECT h FROM hotel h JOIN h.habitaciones ha  
		TypedQuery<Hotel> myQuery = this.entitymanager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha",Hotel.class);
		List<Hotel> listaHoteles = myQuery.getResultList();
		for (Hotel hotel : listaHoteles) {
			hotel.getHabitaciones().size();
		}
		return listaHoteles;
	}

	@Override
	public List<Hotel> seleccionerOuterRightJoin() {
		// TODO Auto-generated method stub
		//select * from hotel h join habitacion ha on h.hot_id = ha.habi_id_hotel
				//pone onde hago la seleccion del atributo
				//SELECT h FROM hotel h JOIN h.habitaciones ha  
				TypedQuery<Hotel> myQuery = this.entitymanager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha",Hotel.class);
				
				return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> seleccionerLeftRightJoin() {
		// TODO Auto-generated method stub
		//select * from hotel h join habitacion ha on h.hot_id = ha.habi_id_hotel
				//pone onde hago la seleccion del atributo
				//SELECT h FROM hotel h JOIN h.habitaciones ha  
				TypedQuery<Hotel> myQuery = this.entitymanager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",Hotel.class);
				
				return myQuery.getResultList();
	}

	
	
	
	@Override
	public List<Hotel> seleccionerOuterFullJoin() {
		// TODO Auto-generated method stub
		//select * from hotel h join habitacion ha on h.hot_id = ha.habi_id_hotel
				//pone onde hago la seleccion del atributo
				//SELECT h FROM hotel h JOIN h.habitaciones ha  
				TypedQuery<Hotel> myQuery = this.entitymanager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones ha",Hotel.class);
				
				return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// TODO Auto-generated method stub
		//Select h.* from hotel h , habitacion ha where h.hot_id = ha.habi_id_hotel
		//SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel
		TypedQuery<Hotel> myQuery = this.entitymanager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel",Hotel.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entitymanager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha",Hotel.class);
		
		
		return myQuery.getResultList();
	}


    
}