package it.sirfin.rubricaserver.service;

import it.sirfin.rubricaserver.model.Contatto;
import java.util.List;


public interface RubricaService {
    void svuotaRubrica();
    List<Contatto> inserisciContatto(Contatto contatto);
    List<Contatto> recuperaContatti();
    List<Contatto> cancellaContatto(Contatto contatto);
}
