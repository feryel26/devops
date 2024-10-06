package tn.esprit.spring_projet.Controllers;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring_projet.Services.EtudiantService;
import tn.esprit.spring_projet.entities.Etudiant;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("/alletudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/addetudiants")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addEtudiants(etudiants);
    }

    @PutMapping("/updateetudiants")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/{id}")
    public Etudiant retrieveEtudiant(@PathVariable long id) {
        return etudiantService.retrieveEtudiant(id);
    }

    @DeleteMapping("/{id}")
    public void removeEtudiant(@PathVariable long id) {
        etudiantService.removeEtudiant(id);
    }
    /*@GetMapping("/by-chambre/{chambreId}")
    public List<Etudiant> getEtudiantsByChambreId(@PathVariable Long chambreId) {
        return etudiantService.findEtudiantsByChambreId(chambreId);
    }*/
}
