package it.sirfin.rubricaserver.repository;

import it.sirfin.rubricaserver.model.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Long> {
    
}
