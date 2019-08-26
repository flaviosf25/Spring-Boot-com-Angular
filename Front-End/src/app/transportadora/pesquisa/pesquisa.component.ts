import { Transportadora } from './../classes/transportadora';
import { Filtro } from './../filtros/filtro';

import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { TransportadoraService } from '../service/transportadora.service';

@Component({
  selector: 'app-pesquisa',
  templateUrl: './pesquisa.component.html',
  styleUrls: ['./pesquisa.component.css']
})
export class PesquisaComponent implements OnInit {

  listaEstados = ['', 'AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 
  'PA', 'PB', 'PR', 'PE', 'PI', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO'];
  
  listaModal = ['', 'Rodoviário', 'Aquaviário', 'Aério'];

   transportadora: Transportadora;
   transportadoras: Transportadora[];
   filtro: Filtro;

  constructor(private route: ActivatedRoute, private router: Router, 
    private transportadoraService: TransportadoraService) { 
      this.transportadora = new Transportadora();
      this.filtro = new Filtro();
    }

  ngOnInit() {
  }

  onSubmit(){
      console.log(this.filtro);
      this.transportadoraService.pesqusiarTransportadora().subscribe(data =>{
      this.router.navigate['lista'];
    });

  }

}
