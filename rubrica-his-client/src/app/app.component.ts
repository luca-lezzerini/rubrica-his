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
  pulsanteCanc:boolean[] = [];
  clientNotFound:boolean = false;
  
  stato = "START";

  constructor(private http: HttpClient) { }

  inserisciContatto() {
    this.stato = "AGG";
    
  }
  confermaAggiunta() {
    this.stato = "START";
    let oss: Observable<ResRubricaDto>
    oss = this.http.post<ResRubricaDto>("http://localhost:8080/inseriscicontatto", this.contatto)
    oss.subscribe(risp => {
      this.rubricaVisualizzata = risp.rubrica,
        this.contatto = new ReqContattoDto();
    })
  }

  annullaAggiunta() {
    this.stato = "START";
    this.contatto = new ReqContattoDto();
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

    if(this.rubricaVisualizzata.length == 0){
      this.clientNotFound = true;
    }else{
      this.clientNotFound = false;
    }

    for(let i = 0;i<this.rubricaVisualizzata.length;i++){
      this.pulsanteCanc[i] = false;
    }
  }


  confermaCancellaContatto(i: number) {
    this.stato = "VIS";
    let oss: Observable<ResRubricaDto>
    oss = this.http.post<ResRubricaDto>("http://localhost:8080/cancellacontatto", this.rubricaVisualizzata[i])
    oss.subscribe(risp => this.rubricaVisualizzata = risp.rubrica)
    this.pulsanteCanc[i] = false;
  }

  cancellaContatto(i:number) {
    this.stato = "CANC";
    this.pulsanteCanc[i] = true;
  }

  annullaCancella(i:number) {
    this.stato = "VIS";
    this.pulsanteCanc[i] = false;
  }

  svuotaRubrica() {
    let oss: Observable<ResRubricaDto>
    oss = this.http.post<ResRubricaDto>("http://localhost:8080/svuotarubrica", this.rubricaVisualizzata)
    oss.subscribe(risp => this.rubricaVisualizzata = risp.rubrica)
  }


}
