package it.sirfin.rubricaserver.Dto;

public class ReqContattoDto {

    private int id;
    private String nome;
    private String cognome;
    private String telefono;

    public ReqContattoDto(int id, String nome, String cognome, String telefono) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ReqContattoDto{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono + '}';
    }

    public ReqContattoDto() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
}
