import { Filtro } from './../filtros/filtro';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Transportadora } from './../classes/transportadora';

@Injectable({
  providedIn: 'root'
})
export class TransportadoraService {
  private readonly API: string;

  constructor(private http: HttpClient) {
    this.API = '/api/transportadora'; 
  }

  public listarTransportadora(){
    return this.http.get<Transportadora[]>(this.API);
  }

  public inserir(tranasportadora: Transportadora){
    return this.http.post<Transportadora>(this.API, tranasportadora);
  }

  public alterar(transportadora: Transportadora){
    return this.http.put<Transportadora>(this.API, transportadora);
  }

  public excluir(id: number){
    return this.http.delete<Transportadora>(this.API + '/' + id);
  }
  
  public consultarPorId(id: number){
    return this.http.get<Transportadora>(this.API + '/' + id);
  }

  public pesqusiarTransportadora(){
    return this.http.get<Transportadora[]>(this.API + '/pesquisar');

  }

}
