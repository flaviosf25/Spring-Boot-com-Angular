import { Telefone } from './telefone';
import { Endereco } from './endereco';
import { Modal } from './modal';
export class Transportadora {
    id: number; 
    nome: string;
    email: string;
    empresa: string;
    modal: Modal = new Modal();
    telefone: Telefone = new Telefone();
    endereco: Endereco = new Endereco();
}
