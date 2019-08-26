package br.com.hc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;


import br.com.hc.filtros.FiltroConsultarTransportadora;
import br.com.hc.model.Transportadora;

@Repository
public interface TransportadoraConsultas {
	
	List<Transportadora> pesquisarTransportadora(FiltroConsultarTransportadora filtro);

}
