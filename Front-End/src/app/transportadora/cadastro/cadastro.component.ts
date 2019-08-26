import { Endereco } from './../classes/endereco';
import { HttpClient } from '@angular/common/http';
import { Transportadora } from './../classes/transportadora';
import { Component, OnInit } from '@angular/core';

import { TransportadoraService } from './../service/transportadora.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  listaEstados = ['', 'AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 
  'PA', 'PB', 'PR', 'PE', 'PI', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO'];
  
  listaModal = ['', 'Rodoviário', 'Aquaviário', 'Aério'];

  transportadora: Transportadora;

  constructor(private route: ActivatedRoute, private router: Router, 
    private transportadoraService: TransportadoraService,
    private http: HttpClient) { 
      this.transportadora = new Transportadora();
    }

  ngOnInit() {
  }

  onSubmit(){
    this.transportadoraService.inserir(this.transportadora).subscribe(data => {
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
