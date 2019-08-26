import { Router, ActivatedRoute } from '@angular/router';
import { async } from '@angular/core/testing';
import { Telefone } from './../classes/telefone';
import { TransportadoraService } from './../service/transportadora.service';
import { Transportadora } from './../classes/transportadora';
import { Component, OnInit } from '@angular/core';
import { Endereco } from '../classes/endereco';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {
  transportadoras: Transportadora[];

  constructor(private route: ActivatedRoute,
    private router: Router,
    private transportadoraService: TransportadoraService) {
  }

  ngOnInit() {
    this.transportadoraService.listarTransportadora().subscribe(data => {
      this.transportadoras = data;
    });
  }

  editarTransportadora(id) {
    this.router.navigate(['alterar-remover', id], { relativeTo: this.route });

  }


}
