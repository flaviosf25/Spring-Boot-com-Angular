import { TransportadoraService } from './../service/transportadora.service';
import { Transportadora } from './../classes/transportadora';

import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { HttpParams, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-alterar-remover',
  templateUrl: './alterar-remover.component.html',
  styleUrls: ['./alterar-remover.component.css']
})
export class AlterarRemoverComponent implements OnInit {

  transportadora: Transportadora;

  listaEstados = ['', 'AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 
  'PA', 'PB', 'PR', 'PE', 'PI', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO'];
  
  listaModal = ['', 'Rodoviário', 'Aquaviário', 'Aério'];

  constructor(private route: ActivatedRoute, 
    private router: Router, 
    private transportadoraService: TransportadoraService,
    private http: HttpClient) { 
       this.transportadora = new Transportadora();     
    }

  ngOnInit() {

    this.route.params.subscribe(
      (params: any) =>{
        const id = params['id'];
        console.log(id);
        this.editarTransportadora(id);
      }
    ); 
  }

  onSubmit(){
  }

  
  editarTransportadora(id){
    this.transportadoraService.consultarPorId(id).subscribe(data =>{
      this.transportadora.id = data.id;
      this.transportadora.nome = data.nome;
      this.transportadora.email = data.email;
      this.transportadora.empresa = data.empresa;
      this.transportadora.telefone.nuTelefone = data.telefone.nuTelefone;
      this.transportadora.telefone.nuCelular = data.telefone.nuCelular;
      this.transportadora.telefone.nuWhatsapp = data.telefone.nuWhatsapp;
      this.transportadora.modal.modal = data.modal.modal;
      this.transportadora.endereco.nuCEP = data.endereco.nuCEP;
      this.transportadora.endereco.bairro =  data.endereco.bairro;
      this.transportadora.endereco.cidade = data.endereco.cidade;
      this.transportadora.endereco.estado = data.endereco.estado;
      this.transportadora.endereco.logradouro = data.endereco.logradouro;
      this.transportadora.endereco.numero = data.endereco.numero;
    });
  }

  alterarTransportadora(transportadora: Transportadora){
    this.transportadoraService.alterar(transportadora).subscribe(data =>{
      this.router.navigate(['lista']);
    });
  }

  excluirTransportadora(id: number){
    this.transportadoraService.excluir(id).subscribe(data =>{
      this.router.navigate(['lista']);
    });
  }

  consultaCEP(cep){
    console.log(cep);
    cep = cep.replace(/\D/g,'');

    if(cep != ""){
      var validaCEP = /^[0-9]{8}$/;

      if(validaCEP.test(cep)){
        this.http.get(`//viacep.com.br/ws/${cep}/json`)
        .subscribe(dados => this.populaDadosEndereco(dados));
      }
    }
  }

  populaDadosEndereco(dados){
    this.transportadora.endereco.estado = dados.uf;
    this.transportadora.endereco.cidade = dados.localidade;
    this.transportadora.endereco.bairro = dados.bairro;
    this.transportadora.endereco.logradouro = dados.logradouro;

  }

}
