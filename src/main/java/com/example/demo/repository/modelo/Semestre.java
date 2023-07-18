package com.example.demo.repository.modelo;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "semestre")
public class Semestre {
	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE ) 
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@Id
	@Column(name = "sem_id")
	private Integer id;
	@Column(name = "sem_num_semestre")
	private String numSemestre;
	@Column(name = "sem_tipo")
	private String tipo;
	@Column(name = "sem_numero")
	private String numero;
	@OneToMany(mappedBy = "semestre")
	private List<Semestre> semestres;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumSemestre() {
		return numSemestre;
	}
	public void setNumSemestre(String numSemestre) {
		this.numSemestre = numSemestre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<Semestre> getSemestres() {
		return semestres;
	}
	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}
	
	

}
