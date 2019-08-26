import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { PesquisaComponent } from './transportadora/pesquisa/pesquisa.component';
import { ListaComponent } from './transportadora/lista/lista.component';
import { CadastroComponent } from './transportadora/cadastro/cadastro.component';
import { AlterarRemoverComponent } from './transportadora/alterar-remover/alterar-remover.component'; 
import { TransportadoraService } from './transportadora/service/transportadora.service';

@NgModule({
  declarations: [
    AppComponent,
    PesquisaComponent,
    ListaComponent,
    CadastroComponent,
    AlterarRemoverComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule
  ],
  providers: [TransportadoraService],
  bootstrap: [AppComponent]
})
export class AppModule { }
