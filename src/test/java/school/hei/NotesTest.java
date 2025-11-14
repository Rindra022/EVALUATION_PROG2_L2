package school.hei;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotesTest {
    private Student student1;
    private Student student2;
    private Notes note1;
    private Notes note2;
    private Cours coursPROG2;
    private Exam exam1;
    private Teacher teacher1;




    @BeforeEach
    public void setUp(){

        Tutor tutor1 = new Tutor(1, "MAHERISON", "Ravaka", LocalDate.parse("1985-08-22"),
                "rava@gmail.com", "0345895254", "Enseignant module POO"
        );

        HistoryNote hist1 = new HistoryNote(
                10,
                Instant.parse("2024-10-20T10:18:00Z"),
                "Première saisie de la note par l’enseignant"
        );
        HistoryNote hist2 = new HistoryNote(
                12,
                Instant.parse("2024-12-17T09:05:00Z"),
                "Correction après réclamation de l’étudiant"
        );


        teacher1 = new Teacher(1, "RAKOTOMALALA", "Jean", LocalDate.parse("1970-02-11"),
                "jean@gmail.com", "0374589614", "Back-end"
        );


        coursPROG2 = new Cours(1, "PROG2", 8, teacher1);

        student1 = new Student(1, "ANDRIANIAINA", "Toky", LocalDate.parse("2002-05-11"),
                "toky@gmail.com", "0328715221", "K2", tutor1);
        student2 = new Student(2, "BLACKMAMBA", "Ikala", LocalDate.parse("2002-05-11"),
                "Ikala@gmail.com", "0254822", "K2", tutor1);


        note1 = new Notes(
                15,
                student1,
                List.of(hist1,hist2)
        );
        note2 = new Notes(
                11,
                student2,
                List.of(hist2)
        );

        exam1 = new Exam(1, "Examen Final - Programmation Orientée Objet",
                LocalDateTime.parse("2024-12-15T08:30:00"), 3,List.of(note1, note2)
        );

    }

    @Test
    public void Note_student_exam_at_instant_t(){
        double noteStd1 = exam1.getCourseGrade(student1,  Instant.parse("2024-11-17T09:05:00Z") );

        assertEquals(10, noteStd1);
    }
}
