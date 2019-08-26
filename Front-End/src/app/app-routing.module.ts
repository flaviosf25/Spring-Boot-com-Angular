import { ListaComponent } from './transportadora/lista/lista.component';
import { CadastroComponent } from './transportadora/cadastro/cadastro.component';
import { AlterarRemoverComponent } from './transportadora/alterar-remover/alterar-remover.component';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  { path: 'alterar-remover/:id', component: AlterarRemoverComponent },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'lista', component: ListaComponent },
  { path: '', component: ListaComponent }
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
  

})
export class AppRoutingModule { }
