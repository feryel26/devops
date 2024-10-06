package tn.esprit.spring_projet.Services;

import org.springframework.stereotype.Service;
import tn.esprit.spring_projet.entities.Etudiant;

import java.util.List;
@Service
public interface EtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant updateEtudiant(Etudiant etudiant);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
    //public List<Etudiant> findEtudiantsByChambreId(Long idChambre);
}





