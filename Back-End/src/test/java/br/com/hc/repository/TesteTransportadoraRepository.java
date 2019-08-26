package br.com.hc.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hc.filtros.FiltroConsultarTransportadora;
import br.com.hc.model.Endereco;
import br.com.hc.model.Modal;
import br.com.hc.model.Telefone;
import br.com.hc.model.Transportadora;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteTransportadoraRepository {
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	@Autowired
	private TransportadoraConsultas transportadoraConsultas;
	
	@Test
	public void testeCadastrarTransportadora() {
		Endereco endereco = new Endereco();
		endereco.setEstado("PE");
		endereco.setCidade("Recife");
		endereco.setBairro("Recife");
		endereco.setLogradouro("Paco Alfandega");
		endereco.setNuCEP("54410778");
		endereco.setNumero("25");
		
		Endereco endereco2 = new Endereco();
		endereco2.setEstado("CE");
		endereco2.setCidade("Fortaleza");
		endereco2.setBairro("Jão XXIII");
		endereco2.setLogradouro("Lagoa da Parangaba");
		endereco2.setNuCEP("54410778");
		endereco2.setNumero("35");
		
		Telefone telefone = new Telefone();
		telefone.setNuCelular("11111111");
		telefone.setNuTelefone("22222222");
		telefone.setNuWhatsapp("33333333");
		
		Telefone telefone2 = new Telefone();
		telefone2.setNuCelular("44444444");
		telefone2.setNuTelefone("55555555");
		telefone2.setNuWhatsapp("66666666");
		
		Modal modal = new Modal();
		modal.setModal("Aerio");
		modal.setTipoModal(1);
		
		Modal modal2 = new Modal();
		modal2.setModal("Rodoviario");
		modal2.setTipoModal(2);
		
		Transportadora transportadora = new Transportadora();
		transportadora.setEmail("hive.cloud@gmail.com");
		transportadora.setNome("Hive Cloud");
		transportadora.setEmpresa("Hive Cloud Solucoes");
		transportadora.setEndereco(endereco);
		transportadora.setTelefone(telefone);
		transportadora.setModal(modal);
		
		Transportadora transportadora2 = new Transportadora();
		transportadora2.setEmail("praxio@gmail.com");
		transportadora2.setNome("Praxio");
		transportadora2.setEmpresa("Praxio Solucoes");
		transportadora2.setEndereco(endereco2);
		transportadora2.setTelefone(telefone2);
		transportadora2.setModal(modal2);
		
		Transportadora transCadastrada = transportadoraRepository.save(transportadora);
		Transportadora transCadastrada2 = transportadoraRepository.save(transportadora2);
		Assert.assertNotNull(transCadastrada.getId());
		Assert.assertNotNull(transCadastrada2.getId());
		
		System.out.println("Transportadoras Cadastradas >>>>>>>>>>>>>>>>>>>>");
		System.out.println("Transportadora:  " + transCadastrada.getNome());
		System.out.println("Transportadora:  " + transCadastrada2.getNome());
		
	}
	
	@Test
	public void testeConsultarTodasTransprtadoras() {
		
		List<Transportadora> listaTransportadora = transportadoraRepository.findAll();
		assertThat(!listaTransportadora.isEmpty());
		
		System.out.println("Transportadoras Listadas >>>>>>>>>>>>>>>>>>>>>>>>");
		for( Transportadora listaTr: listaTransportadora) {
			System.out.println("Transportadora:  " + listaTr.getNome());
		}
		
	}
	
	@Test
	public void testePesquisarTransportadora() {
		Endereco endereco = new Endereco();
		endereco.setEstado("PE");
		endereco.setCidade("Recife");
		endereco.setBairro("Recife");
		endereco.setLogradouro("Paco Alfandega");
		endereco.setNuCEP("54410778");
		endereco.setNumero("25");
		
		Telefone telefone = new Telefone();
		telefone.setNuCelular("11111111");
		telefone.setNuTelefone("22222222");
		telefone.setNuWhatsapp("33333333");
		
		Modal modal = new Modal();
		modal.setModal("Aerio");
		modal.setTipoModal(1);
		
		Transportadora transportadora = new Transportadora();
		transportadora.setEmail("testando@gmail.com");
		transportadora.setNome("Testes Unitarios");
		transportadora.setEmpresa("JUnit Solucoes");
		transportadora.setEndereco(endereco);
		transportadora.setTelefone(telefone);
		transportadora.setModal(modal);
		
		Transportadora transCadastrada = transportadoraRepository.save(transportadora);
		
		FiltroConsultarTransportadora filtro = new FiltroConsultarTransportadora();
		filtro.setNome(transCadastrada.getNome());
		filtro.setEstado(transCadastrada.getEndereco().getEstado());
		filtro.setCidade(transCadastrada.getEndereco().getCidade());
		filtro.setModal(transCadastrada.getModal().getModal());
		
		List<Transportadora> transPesquisada = transportadoraConsultas.pesquisarTransportadora(filtro);
		assertThat(transPesquisada.get(0).getNome()).isEqualTo(transCadastrada.getNome());
		assertThat(transPesquisada.get(0).getEndereco().getEstado()).isEqualTo(transCadastrada.getEndereco().getEstado());
		
		System.out.println("Transportadora Pesquisada >>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Transportadora:  " + transPesquisada.get(0).getNome());
		
	}
	
	@Test
	public void testeUpdateTransportadora() {
		Endereco endereco = new Endereco();
		endereco.setEstado("PE");
		endereco.setCidade("Recife");
		endereco.setBairro("Boa Viagem");
		endereco.setLogradouro("Av. Boa Viagem");
		endereco.setNuCEP("54410880");
		endereco.setNumero("36");
		
		Telefone telefone = new Telefone();
		telefone.setNuCelular("95238115");
		telefone.setNuTelefone("95238115");
		telefone.setNuWhatsapp("95238115");
		
		Modal modal = new Modal();
		modal.setModal("Maritimo");
		modal.setTipoModal(3);
		
		Transportadora  trans = new Transportadora();
		trans.setId(1);
		trans.setNome("Fique Rico ou Morra Tentando");
		trans.setEmpresa("HC Transportadora");
		trans.setEmail("alterada@gamil.com");
		trans.setTelefone(telefone);
		trans.setModal(modal);
		Transportadora transAlterada = transportadoraRepository.save(trans);
		
		assertThat(transAlterada.getNome()).isEqualTo(trans.getNome());
		assertThat(transAlterada.getEmpresa()).isEqualTo(trans.getEmpresa());
		
		System.out.println("Transportadora com ID 1 Alterada para >>>>>>>>>>>");
		System.out.println("Transportadora:  " + transAlterada.getNome());
	}
	
	@Test
	public void testeRemoverTransportadora() {
		Endereco endereco = new Endereco();
		endereco.setEstado("PE");
		endereco.setCidade("Recife");
		endereco.setBairro("Boa Viagem");
		endereco.setLogradouro("Av. Boa Viagem");
		endereco.setNuCEP("54410880");
		endereco.setNumero("36");
		
		Telefone telefone = new Telefone();
		telefone.setNuCelular("95238115");
		telefone.setNuTelefone("95238115");
		telefone.setNuWhatsapp("95238115");
		
		Modal modal = new Modal();
		modal.setModal("Maritimo");
		modal.setTipoModal(3);
		
		Transportadora  trans = new Transportadora();
		trans.setId(1);
		trans.setNome("HC Transportadora");
		trans.setEmpresa("Fique Rico ou Morra Tentando");
		trans.setEmail("alterada@gamil.com");
		trans.setTelefone(telefone);
		trans.setModal(modal);
		transportadoraRepository.save(trans);
		
		Transportadora transportadora = new Transportadora();
		transportadora = transportadoraRepository.findById(1);
		transportadoraRepository.delete(transportadora);
		List<Transportadora> listaTransportadora = transportadoraRepository.findAll();
		assertThat(listaTransportadora.isEmpty());
		
		System.out.println("Transportadora com ID 1 Removida >>>>>>>>>>>>>>>>");
		
	}
}
