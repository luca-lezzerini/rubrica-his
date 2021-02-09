package it.sirfin.rubricaserver.service;

import it.sirfin.rubricaserver.dto.ReqContattoDto;
import java.util.List;


public interface RubricaService {
    List<ReqContattoDto> svuotaRubrica();
    List<ReqContattoDto> inserisciContatto(ReqContattoDto contatto);
    List<ReqContattoDto> recuperaContatti();
    List<ReqContattoDto> cancellaContatto(ReqContattoDto contatto);
}
