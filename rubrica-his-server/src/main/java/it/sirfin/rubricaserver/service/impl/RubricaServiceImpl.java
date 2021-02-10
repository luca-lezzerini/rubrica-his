package it.sirfin.rubricaserver.service.impl;

import it.sirfin.rubricaserver.dto.ReqContattoDto;
import it.sirfin.rubricaserver.service.RubricaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RubricaServiceImpl implements RubricaService {

    //inizializziamo un contatore a 0 e ci creiamo un ArrayList
    int cont = 0;
    List<ReqContattoDto> rubricaService = new ArrayList<>();

    //Nel metodo svuotaRubrica trmite ".clear" andiamo ad eliminare tutti i
    //campi dell' ArrayList
    @Override
    public List<ReqContattoDto> svuotaRubrica() {
        this.rubricaService.clear();
        this.cont = 0;
        return this.rubricaService;
    }
   
    //Nel metodo inserisciContatto andiamo a settare il valore Id incrementandolo
    //ed utilizziamo ".add" per aggiungere il contatto nell' ArrayList
    @Override
    public List<ReqContattoDto> inserisciContatto(ReqContattoDto contatto) {
        contatto.setId(cont);
        cont++;
        this.rubricaService.add(contatto);
        return this.rubricaService;
    }

    @Override
    public List<ReqContattoDto> recuperaContatti() {
        return this.rubricaService;
    }

    //Nel metodo cancellaContatto utilizziamo "remove" che rimuove tutto ma
    //affiancando un If riusciamo anche a cancellare il giusto Id
    @Override
    public List<ReqContattoDto> cancellaContatto(ReqContattoDto contatto) {
        this.rubricaService.removeIf(rs -> rs.getId() == contatto.getId());
        return this.rubricaService;
    }
}
