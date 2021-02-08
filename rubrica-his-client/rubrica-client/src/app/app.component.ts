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
  title = 'rubrica-client';
  contatto: ReqContattoDto = new ReqContattoDto();
  rispostaInserisciContatti = "";
  rispostaRecuperaContatti = "";
  rubrica: ResRubricaDto[] = [];


  stato = "START";

  constructor(private http: HttpClient) { }

  inserisciContatto() {
    this.stato = "AGG";

  }
  confermaAggiunta() {
    this.stato = "START";
    let oss: Observable<string>
    oss = this.http.post<string>("http://localhost:8080/inseriscicontatto", this.contatto)
    oss.subscribe(risp => {
      this.rispostaInserisciContatti = risp,
        this.contatto = new ReqContattoDto();
    })
  }

  annullaAggiunta() {
    this.stato = "START";
  }

  recuperaContatti() {
    this.stato = "VIS";
    let oss: Observable<ResRubricaDto[]>
    oss = this.http.get<ResRubricaDto[]>("http://localhost:8080/recuperatuttiicontatti")
    oss.subscribe(risp => this.rubrica = risp)
  }


  confermaCancellaContatto(i: number) {
    this.stato = "VIS"
    let oss: Observable<ResRubricaDto[]>
    oss = this.http.post<ResRubricaDto[]>("http://localhost:8080/cancellacontatto", this.rubrica[i])
    oss.subscribe(risp => this.rubrica = risp)
  }

  cancellaContatto() {
    this.stato = "CANC";
  }

  annullaCancella() {
    this.stato = "VIS";
  }

  svuotaRubrica() {
    let oss: Observable<ResRubricaDto[]>
    oss = this.http.post<ResRubricaDto[]>("http://localhost:8080/svuotarubrica", this.rubrica)
    oss.subscribe(risp => this.rubrica = risp)
  }


}
