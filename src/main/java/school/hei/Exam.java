package school.hei;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
public class Exam {
    private int id;
    private String title;
    private LocalDateTime date;
    private int coefficient;
    private List<Notes> ListNotes;

    double getCourseGrade (Student student, Instant t){
       return ListNotes.stream()
               .filter(notes -> notes.getStudent().equals(student))
               .findFirst()
               .map(Notes::getListHistoryNotes)
               .flatMap(h-> h.stream()
                       .filter(historyNote -> historyNote.getDateCreation().isBefore(t))
                       .max(Comparator.comparing(HistoryNote::getDateCreation))
               )
               .map(HistoryNote::getNote)
               .orElse(0.0);
    }
}
