package tn.esprit.spring_projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring_projet.entities.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

        //@Query("SELECT DISTINCT e FROM Etudiant e JOIN e.reservations r WHERE r.chambre.idChambre = :idChambre")
       // List<Etudiant> findEtudiantsByChambreId(@Param("idChambre") Long idChambre);
    }



