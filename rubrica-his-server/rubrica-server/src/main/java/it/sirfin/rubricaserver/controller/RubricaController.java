package it.sirfin.rubricaserver.controller;

import it.sirfin.rubricaserver.Dto.ReqContattoDto;
import it.sirfin.rubricaserver.Dto.ResRubricaDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RubricaController {

    int cont = 0;
    List<ReqContattoDto> preRubrica = new ArrayList<>();

    @RequestMapping("/provarubrica")
    public String provaRubrica() {
        return "Il server funziona";
    }

    @RequestMapping("/svuotarubrica")
    public List<ReqContattoDto> svuotaRubrica() {
        this.preRubrica = new ArrayList();
        this.cont = 0;
        return this.preRubrica;
    }

    @RequestMapping("/inseriscicontatto")
    public List<ReqContattoDto> inserisciContatto(@RequestBody ReqContattoDto contatto) {
        contatto.setId(cont);
        this.preRubrica.add(contatto);
        cont += 1;
        return this.preRubrica;

    }

    @RequestMapping("/recuperatuttiicontatti")
    public List<ReqContattoDto> recuperContatti() {
        return this.preRubrica;
    }

    @RequestMapping("/cancellacontatto")
    public List<ReqContattoDto> cancellaContatto(@RequestBody ReqContattoDto dto) {
        this.preRubrica.forEach(pr -> {
            if (pr.getId() == dto.getId()) {
                System.out.println("Elemento trovato alla posizione: " + this.preRubrica.indexOf(pr));
                int indice = this.preRubrica.indexOf(pr);
                this.preRubrica.remove(pr);
            }
        });
        return this.preRubrica;

    }

    @RequestMapping("/addDefault")
    public ResRubricaDto addDefault() {
        this.preRubrica.add(new ReqContattoDto(100, "xxx", "xxx", "654321"));
        this.preRubrica.add(new ReqContattoDto(100, "xxx", "xxx", "654321"));
        this.preRubrica.add(new ReqContattoDto(100, "xxx", "xxx", "654321"));
        return new ResRubricaDto(this.preRubrica);
    }

}
