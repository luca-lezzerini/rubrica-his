import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { ReqContattoDto } from './req-contatto-dto';
import { HttpClient } from '@angular/common/http';
import { ResRubricaDto } from './res-rubrica-dto';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  contatto: ReqContattoDto = new ReqContattoDto();
  rubricaVisualizzata: ReqContattoDto[] = [];
  pulsanteCanc: boolean[] = [];
  cancDisabled: boolean = false;
  clientNotFound: boolean = false;

  emptyFields: boolean = false;
  emptyNome: boolean = false;
  emptyCognome: boolean = false;
  emptyTelefono: boolean = false;

  stato = "START";

  constructor(private http: HttpClient) { }

  inserisciContatto() {
    this.stato = "AGG";

  }
  confermaAggiunta() {
    if (this.contatto.nome != "" && this.contatto.cognome != "" && this.contatto.telefono != "") {

      this.emptyNome = false;
      this.emptyCognome = false;
      this.emptyTelefono = false;
      this.emptyFields = false;
      this.stato = "START";
      let oss: Observable<ResRubricaDto>
      oss = this.http.post<ResRubricaDto>("http://localhost:8080/inseriscicontatto", this.contatto)
      oss.subscribe(risp => {
        this.rubricaVisualizzata = risp.rubrica,
          this.contatto = new ReqContattoDto();
      })

    } else if (this.contatto.nome == "" && this.contatto.cognome != "" && this.contatto.telefono != "") {
      this.emptyNome = true;
      this.emptyCognome = false;
      this.emptyTelefono = false;
      this.emptyFields = false;
    } else if (this.contatto.nome == "" && this.contatto.cognome == "" && this.contatto.telefono != "") {
      this.emptyNome = true;
      this.emptyCognome = true;
      this.emptyTelefono = false;
      this.emptyFields = false;
    } else if (this.contatto.nome == "" && this.contatto.cognome != "" && this.contatto.telefono == "") {
      this.emptyNome = true;
      this.emptyTelefono = true;
      this.emptyCognome = false;
      this.emptyFields = false;
    } else if (this.contatto.nome != "" && this.contatto.cognome == "" && this.contatto.telefono != "") {
      this.emptyCognome = true;
      this.emptyNome = false;
      this.emptyTelefono = false;
      this.emptyFields = false;
    } else if (this.contatto.nome != "" && this.contatto.cognome == "" && this.contatto.telefono == "") {
      this.emptyCognome = true;
      this.emptyTelefono = true;
      this.emptyNome = false;
      this.emptyFields = false;
    } else if (this.contatto.nome != "" && this.contatto.cognome != "" && this.contatto.telefono == "") {
      this.emptyTelefono = true;
      this.emptyNome = false;
      this.emptyFields = false;
      this.emptyCognome = false;
    } else {
      this.emptyFields = true;
      this.emptyTelefono = false;
      this.emptyNome = false;
      this.emptyCognome = false;
    }

  }

  annullaAggiunta() {
    this.stato = "START";
    this.contatto = new ReqContattoDto();
    this.emptyNome = false;
    this.emptyCognome = false;
    this.emptyTelefono = false;
    this.emptyFields = false;
  }

  //aggiornare l'argomento degli osservabili come in questo da "<ReqContattoDto[]>"
  //a "<ResRubricaDto>" 
  //aggiornare risposte rest inserendo nella rubrica visualizzata la proprietà
  //"rubrica" della classe ResRubricaDto.
  recuperaContatti() {
    this.stato = "VIS";
    let oss: Observable<ResRubricaDto>
    oss = this.http.get<ResRubricaDto>("http://localhost:8080/recuperatuttiicontatti")
    oss.subscribe(risp => {
      this.rubricaVisualizzata = risp.rubrica

    })

    if (this.rubricaVisualizzata.length == 0) {
      this.clientNotFound = true;
    } else {
      this.clientNotFound = false;
    }

    for (let i = 0; i < this.rubricaVisualizzata.length; i++) {
      this.pulsanteCanc[i] = false;
    }
  }


  confermaCancellaContatto(i: number) {
    this.stato = "VIS";
    let oss: Observable<ResRubricaDto>
    oss = this.http.post<ResRubricaDto>("http://localhost:8080/cancellacontatto", this.rubricaVisualizzata[i])
    oss.subscribe(risp => this.rubricaVisualizzata = risp.rubrica)
    this.pulsanteCanc[i] = false;
    this.cancDisabled = false;

  }

  cancellaContatto(i: number) {
    this.stato = "CANC";
    this.pulsanteCanc[i] = true;
    this.cancDisabled = true;
  }

  annullaCancella(i: number) {
    this.stato = "VIS";
    this.pulsanteCanc[i] = false;
    this.cancDisabled = false;
  }

  svuotaRubrica() {
    let oss: Observable<ResRubricaDto>
    oss = this.http.post<ResRubricaDto>("http://localhost:8080/svuotarubrica", this.rubricaVisualizzata)
    oss.subscribe(risp => this.rubricaVisualizzata = risp.rubrica)
  }


}
