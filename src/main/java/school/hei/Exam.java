package school.hei;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class Exam {
    private int id;
    private String title;
    private LocalDateTime date;
    private int coefficient;
    private List<Notes> ListNotes;
}
