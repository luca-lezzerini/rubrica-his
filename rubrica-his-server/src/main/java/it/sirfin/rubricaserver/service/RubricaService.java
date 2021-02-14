package it.sirfin.rubricaserver.service;

import it.sirfin.rubricaserver.model.Contatto;
import java.util.List;


public interface RubricaService {
    void svuotaRubrica();
    void inserisciContatto(Contatto contatto);
    List<Contatto> recuperaContatti();
    void cancellaContatto(Contatto contatto);
}
