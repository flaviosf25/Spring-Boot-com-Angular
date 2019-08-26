package br.com.hc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.hc.filtros.FiltroConsultarTransportadora;
import br.com.hc.model.Endereco;
import br.com.hc.model.Modal;
import br.com.hc.model.Transportadora;

@Repository
public class TransportadoraConsultasImpl implements TransportadoraConsultas{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Transportadora> pesquisarTransportadora(FiltroConsultarTransportadora filtro) {	
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Transportadora> query = criteriaBuilder.createQuery(Transportadora.class);
		Root<Transportadora> root = query.from(Transportadora.class);
		
		Path<String> nomePath = root.<String> get("nome");
		Path<String> modalPath = root.<Modal> get("modal").<String> get("modal");
		Path<String> enderecoUFPath = root.<Endereco> get("endereco").<String> get("estado");
		Path<String> enderecoCidadePath = root.<Endereco> get("endereco").<String> get("cidade");

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (filtro.getNome() != null && !filtro.getNome().isEmpty()) {
			Predicate nomeIgual = criteriaBuilder.like(nomePath, "%" + filtro.getNome() + "%");
			predicates.add(nomeIgual);
		}

		if (filtro.getEstado() != null && !filtro.getEstado().isEmpty()) {
			Predicate enderecoUFIgual = criteriaBuilder.equal(enderecoUFPath, filtro.getEstado());
			predicates.add(enderecoUFIgual);
		}

		if (filtro.getCidade() != null &&!filtro.getCidade().isEmpty()) {
			Predicate enderecoCidadeIgual = criteriaBuilder.equal(enderecoCidadePath, filtro.getCidade());
			predicates.add(enderecoCidadeIgual);
		}
		
		if (filtro.getModal() != null && !filtro.getModal().isEmpty()) {
			Predicate modalIgual = criteriaBuilder.like(modalPath, filtro.getModal());
			predicates.add(modalIgual);
		}
		
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		TypedQuery<Transportadora> typedQuery = manager.createQuery(query);
		return typedQuery.getResultList();
		
	}

}
