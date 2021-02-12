package it.sirfin.rubricaserver.dto;

import it.sirfin.rubricaserver.model.Contatto;
import java.util.List;

public class ResRubricaDto {
    private List<Contatto> rubrica;

    public ResRubricaDto(List<Contatto> rubrica) {
        this.rubrica = rubrica;
    }

    public ResRubricaDto() {
    }

    public List<Contatto> getRubrica() {
        return rubrica;
    }

    public void setRubrica(List<Contatto> rubrica) {
        this.rubrica = rubrica;
    }
    
}
