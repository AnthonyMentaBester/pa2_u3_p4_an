package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cta_bancaria")
public class CuentaBancaria {
	

	@GeneratedValue(generator = "seq_cta_bancaria", strategy = GenerationType.SEQUENCE ) /// atributo quue permite hacer match
	@SequenceGenerator(name = "seq_cta_bancaria", sequenceName = "seq_cta_bancaria", allocationSize = 1)
	
	@Id
	@Column(name = "cta_id")
	private Integer id;
	@Column(name = "cta_numero")
	private String numero;
	@Column(name = "cta_tipo")
	private String tipo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cta_id_propiertario")
	private Propietario propietario;
	
	

}
