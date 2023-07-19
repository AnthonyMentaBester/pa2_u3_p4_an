package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {
	@GeneratedValue(generator = "seq_provincia", strategy = GenerationType.SEQUENCE ) 
	@SequenceGenerator(name = "seq_provincia", sequenceName = "seq_provincia", allocationSize = 1)
	@Id
	@Column(name = "prov_id")
	private Integer id;
	@Column(name = "prov_ciudad")
	private String ciudad;
	@Column(name = "prov_capital")
	private String capital;
	@Column(name = "prov_region")
	private String region;
	
	@OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL)
	private List<Estudiante> estudiantes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
	

}
