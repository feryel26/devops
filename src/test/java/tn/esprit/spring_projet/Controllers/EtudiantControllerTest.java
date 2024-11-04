package tn.esprit.spring_projet.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.spring_projet.Services.EtudiantService;
import tn.esprit.spring_projet.entities.Etudiant;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EtudiantController.class)
public class EtudiantControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private EtudiantService etudiantService;


    @InjectMocks
    private EtudiantController etudiantController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(etudiantController).build();
    }

    @Test
    public void testRetrieveAllEtudiants() throws Exception {
        Etudiant etudiant1 = new Etudiant(1L, "John", "Doe", 123456789L, "Some School", new Date(), 100);
        Etudiant etudiant2 = new Etudiant(2L, "Jane", "Smith", 987654321L, "Another School", new Date(), 150);

        List<Etudiant> etudiants = Arrays.asList(etudiant1, etudiant2);

        when(etudiantService.retrieveAllEtudiants()).thenReturn(etudiants);

        mockMvc.perform(get("/etudiants/alletudiants")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomEt").value("John"))
                .andExpect(jsonPath("$[1].prenomEt").value("Smith"));

        verify(etudiantService, times(1)).retrieveAllEtudiants();
    }

    @Test
    public void testRetrieveEtudiant() throws Exception {
        Etudiant etudiant = new Etudiant(1L, "John", "Doe", 123456789L, "Some School", new Date(), 100);

        when(etudiantService.retrieveEtudiant(1L)).thenReturn(etudiant);

        mockMvc.perform(get("/etudiants/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomEt").value("John"))
                .andExpect(jsonPath("$.prenomEt").value("Doe"));

        verify(etudiantService, times(1)).retrieveEtudiant(1L);
    }

}
