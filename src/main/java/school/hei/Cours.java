package school.hei;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Getter
public class Cours {
    private int id;
    private String label;
    private int credits;
    private Teacher teacher;
    private List<Exam> listExams;


    public double getCourseGrade(Student student, Instant t){
        double sumNoteWithCoef = listExams.stream()
                .mapToDouble(exam -> (exam.getExamGrade(student, t) * exam.getCoefficient()))
                .sum();

        double totalCoef = listExams.stream()
                .mapToInt(Exam::getCoefficient)
                .sum();
        return (sumNoteWithCoef / totalCoef) * credits;
    }
}
