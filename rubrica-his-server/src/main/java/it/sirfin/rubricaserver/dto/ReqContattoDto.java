package it.sirfin.rubricaserver.dto;

import it.sirfin.rubricaserver.model.Contatto;

public class ReqContattoDto {

    Contatto contatto;

    public ReqContattoDto(Contatto contatto) {
        this.contatto = contatto;
    }

    public ReqContattoDto() {
    }

    public Contatto getContatto() {
        return contatto;
    }

    public void setContatto(Contatto contatto) {
        this.contatto = contatto;
    }

    @Override
    public String toString() {
        return "ReqContattoDto{" + "contatto=" + contatto + '}';
    }
    
}
