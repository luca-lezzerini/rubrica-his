package it.sirfin.rubricaserver.controller;

import it.sirfin.rubricaserver.dto.ReqContattoDto;
import it.sirfin.rubricaserver.dto.ResRubricaDto;
import it.sirfin.rubricaserver.service.RubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RubricaController {

    @Autowired
    RubricaService rubricaService;

    @RequestMapping("/svuotarubrica")
    @ResponseBody
    public ResRubricaDto svuotaRubrica() {
        return new ResRubricaDto(rubricaService.svuotaRubrica());
    }

    @RequestMapping("/inseriscicontatto")
    @ResponseBody
    public ResRubricaDto inserisciContatto(@RequestBody ReqContattoDto contatto) {
        return new ResRubricaDto(rubricaService.inserisciContatto(contatto));
    }

    @RequestMapping("/recuperatuttiicontatti")
    @ResponseBody
    public ResRubricaDto recuperContatti() {
        return new ResRubricaDto(rubricaService.recuperaContatti());
    }

    @RequestMapping("/cancellacontatto")
    @ResponseBody
    public ResRubricaDto cancellaContatto(@RequestBody ReqContattoDto contatto) {
        return new ResRubricaDto(rubricaService.cancellaContatto(contatto));
    }
}
