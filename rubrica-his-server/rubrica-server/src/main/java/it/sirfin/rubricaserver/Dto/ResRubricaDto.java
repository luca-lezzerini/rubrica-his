package it.sirfin.rubricaserver.Dto;

import java.util.List;

public class ResRubricaDto {
    private List<ReqContattoDto> rubrica;

    public ResRubricaDto(List<ReqContattoDto> rubrica) {
        this.rubrica = rubrica;
    }

    public ResRubricaDto() {
    }

    public List<ReqContattoDto> getRubrica() {
        return rubrica;
    }

    public void setRubrica(List<ReqContattoDto> rubrica) {
        this.rubrica = rubrica;
    }
    
}
