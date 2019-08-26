package br.com.hc.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.hc.filtros.FiltroConsultarTransportadora;
import br.com.hc.model.Transportadora;
import br.com.hc.service.TransportadoraService;

@Controller
@CrossOrigin
@RequestMapping("/")
public class TransportadoraController {

	TransportadoraService transService;
	
	@Autowired
	public TransportadoraController(TransportadoraService service) {
		this.transService = service;
	}
	
	@PostMapping("/transportadora")
	public ResponseEntity<Transportadora> cadastrarTransportadora(@RequestBody Transportadora transportadora){		
		Transportadora transPtrCadastrada = transService.cadastrarTransportadora(transportadora);
		return new ResponseEntity<Transportadora>(transPtrCadastrada, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/transportadora")
	public ResponseEntity<Collection<Transportadora>> consultarTodasTransportadoras(){
		Collection<Transportadora> listaTransportadora = transService.consultarTodasTransportadoras();
		return new ResponseEntity<>(listaTransportadora, HttpStatus.OK);	
	}
	
	@GetMapping("/transportadora/{id}")
	public ResponseEntity<Transportadora> consultarTransportadoraPorId(@PathVariable Integer id){
		Transportadora transPtrConsultada = transService.consultarTransportadoraPorId(id);
		return new ResponseEntity<Transportadora>(transPtrConsultada, HttpStatus.OK); 
	}
	
	@DeleteMapping("/transportadora/{id}")
	public ResponseEntity<Transportadora> excluirTransportador(@PathVariable Integer id) throws ServletException{
		Transportadora transPtrParaExclusao = transService.consultarTransportadoraPorId(id);
		
		if(transPtrParaExclusao == null) {
			new ResponseEntity<>(HttpStatus.NOT_FOUND);	
			throw new ServletException("Transportadora não encontrada.");
		}
		
		transService.excluirTransportadora(transPtrParaExclusao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/transportadora")
	public ResponseEntity<Transportadora> alterarTransportadora(@RequestBody Transportadora transportadora){
		Transportadora transPtrAlterada = transService.alterarTransportadora(transportadora);
		return new ResponseEntity<Transportadora>(transPtrAlterada, HttpStatus.OK);
	}
	
	@GetMapping("/transportadora/pesquisar")
	public ResponseEntity<List<Transportadora>> pesquisarTransportadoras(@RequestBody FiltroConsultarTransportadora filtro){
		List<Transportadora> transportadoraPesquisada = transService.pesquisarTransportadora(filtro);
		return new ResponseEntity<>(transportadoraPesquisada, HttpStatus.OK);	
	}
	
}
