package br.com.hc.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hc.filtros.FiltroConsultarTransportadora;
import br.com.hc.model.Transportadora;
import br.com.hc.repository.TransportadoraConsultas;
import br.com.hc.repository.TransportadoraRepository;

@Service
public class TransportadoraService {

	TransportadoraRepository transRepository;
	TransportadoraConsultas transportadoraConsultas;
	
	@Autowired
	public TransportadoraService(TransportadoraRepository repository, TransportadoraConsultas transConsultas){
		this.transRepository = repository;
		this.transportadoraConsultas = transConsultas;
	}
	
	public Transportadora cadastrarTransportadora(Transportadora transportadora) {
		return transRepository.save(transportadora);
	}
	
	public Collection<Transportadora> consultarTodasTransportadoras() {
		return transRepository.findAll();
	}
	
	public Transportadora consultarTransportadoraPorId(int id) {
		return transRepository.findById(id);
	}
	
	public Transportadora alterarTransportadora(Transportadora transportadora) {
		return transRepository.save(transportadora);
	}
	
	public void excluirTransportadora(Transportadora transportadora) {
		transRepository.delete(transportadora);
	}
	
	public List<Transportadora> pesquisarTransportadora(FiltroConsultarTransportadora filtro){
		return transportadoraConsultas.pesquisarTransportadora(filtro);
	}
	
	
}
