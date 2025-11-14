package school.hei;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class Notes {
    private final double initialNote;
    private final Student student;
    private final List<HistoryNote> ListHistoryNotes;

}
