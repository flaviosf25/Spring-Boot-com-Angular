package br.com.hc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nuTelefone;
	
	private String nuCelular;
	
	private String nuWhatsapp;
	
	@OneToOne(cascade = {CascadeType.REMOVE})
	private Transportadora transportadora;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNuTelefone() {
		return nuTelefone;
	}

	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}

	public String getNuCelular() {
		return nuCelular;
	}

	public void setNuCelular(String nuCelular) {
		this.nuCelular = nuCelular;
	}

	public String getNuWhatsapp() {
		return nuWhatsapp;
	}

	public void setNuWhatsapp(String nuWhatsapp) {
		this.nuWhatsapp = nuWhatsapp;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}
	
	

}
