package it.sirfin.rubricaserver.service.impl;

import it.sirfin.rubricaserver.dto.ReqContattoDto;
import it.sirfin.rubricaserver.service.RubricaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RubricaServiceImpl implements RubricaService {

    int cont = 0;
    List<ReqContattoDto> rubricaService = new ArrayList<>();

    @Override
    public List<ReqContattoDto> svuotaRubrica() {
        this.rubricaService.clear();
        this.cont = 0;
        return this.rubricaService;
    }

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

    @Override
    public List<ReqContattoDto> cancellaContatto(ReqContattoDto contatto) {
        this.rubricaService.removeIf(rs -> rs.getId() == contatto.getId());
        return this.rubricaService;
    }
}
