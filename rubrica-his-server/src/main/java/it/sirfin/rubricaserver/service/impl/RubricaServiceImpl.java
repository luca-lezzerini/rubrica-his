package it.sirfin.rubricaserver.service.impl;

import it.sirfin.rubricaserver.model.Contatto;
import it.sirfin.rubricaserver.repository.ContattoRepository;
import it.sirfin.rubricaserver.service.RubricaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubricaServiceImpl implements RubricaService {

    @Autowired
    ContattoRepository contattoRepository;
    //inizializziamo un contatore a 0 e ci creiamo un ArrayList
    List<Contatto> rubricaService = new ArrayList<>();

    //Nel metodo svuotaRubrica trmite ".clear" andiamo ad eliminare tutti i
    //campi dell' ArrayList
    @Override
    public void svuotaRubrica() {
        contattoRepository.deleteAllInBatch();
    }

    //Nel metodo inserisciContatto andiamo a settare il valore Id incrementandolo
    //ed utilizziamo ".add" per aggiungere il contatto nell' ArrayList
    @Override
    public void inserisciContatto(Contatto contatto) {
        contattoRepository.save(contatto);
    }

    @Override
    public List<Contatto> recuperaContatti() {
        return contattoRepository.findAll();
    }

    //cancellaContatto si avvale del metodo removeIf tramite il quale 
    //cancelliamo tutti i contatti che hanno lo stesso id del contatto trasmesso
    //da client.
    @Override
    public void cancellaContatto(Contatto contatto) {
        contattoRepository.delete(contatto);
    }
}
