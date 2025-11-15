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
    private HistoryNote hist1;
    private HistoryNote hist2;
    private HistoryNote hist3;
    private HistoryNote hist4;
    private HistoryNote hist5;
    private Notes note1;
    private Notes note2;
    private Notes note3;
    private Cours coursPROG2;
    private Exam exam1;
    private Exam exam2;
    private Teacher teacher1;




    @BeforeEach
    public void setUp(){

        //TUTORS----
        Tutor tutor1 = new Tutor(1, "MAHERISON", "Ravaka", LocalDate.parse("1985-08-22"),
                "rava@gmail.com", "0345895254", "Enseignant module POO"
        );

        //HISTORY NOTES-----
        hist1 = new HistoryNote(
                19,
                Instant.parse("2024-10-20T10:18:00Z"),
                "Première saisie de la note par l’enseignant"
        );
        hist2 = new HistoryNote(
                17,
                Instant.parse("2024-12-17T09:05:00Z"),
                "Correction après réclamation de l’étudiant"
        );
        hist3 = new HistoryNote(
                11,
                Instant.parse("2024-09-17T09:05:00Z"),
                "Correction après réclamation de l’étudiant"
        );
        hist4 = new HistoryNote(
                18,
                Instant.parse("2024-07-17T09:05:00Z"),
                "Correction après réclamation de l’étudiant"
        );
        hist5 = new HistoryNote(
                10,
                Instant.parse("2024-07-17T09:05:00Z"),
                "Rattrapage"
        );

        //TEACHERS-----
        teacher1 = new Teacher(1, "RAKOTOMALALA", "Jean", LocalDate.parse("1970-02-11"),
                "jean@gmail.com", "0374589614", "Back-end"
        );


        //STUDENTS------
        student1 = new Student(1, "ANDRIANIAINA", "Toky", LocalDate.parse("2002-05-11"),
                "toky@gmail.com", "0328715221", "K2", tutor1);
        student2 = new Student(2, "BLACKMAMBA", "Ikala", LocalDate.parse("2002-05-11"),
                "Ikala@gmail.com", "0254822", "K2", tutor1);

        //NOTES------
        note1 = new Notes(
                15,
                student1,
                List.of(hist1,hist2)
        );
        note2 = new Notes(
                11,
                student2,
                List.of(hist5)
        );
        note3 = new Notes(
                5,
                student1,
                List.of(hist3,hist4)
        );

        //EXAMS------
        exam1 = new Exam(1, "Examen Final - Programmation Orientée Objet",
                LocalDateTime.parse("2024-09-15T08:30:00"), 3,List.of(note1, note2)
        );
        exam2 = new Exam(1, "Examen - SPRING",
                LocalDateTime.parse("2024-06-15T08:30:00"), 2,List.of(note3)
        );

        //COURS-----
        coursPROG2 = new Cours(
                1, "PROG2",
                8, teacher1,
                List.of(exam1, exam2)
        );


    }

    @Test
    public void Note_student_exam_at_instant_t(){
        double noteExamStd1 = exam1.getExamGrade(student1,  Instant.parse("2024-11-17T09:05:00Z") );

        assertEquals(19, noteExamStd1);
    }

    @Test
    public void Note_final_student_cour_at_instant_t(){
        double noteCourStd1= coursPROG2.getCourseGrade(student1, Instant.parse("2025-01-01T09:05:00Z"));

        assertEquals(116.8, noteCourStd1);
    }
}
