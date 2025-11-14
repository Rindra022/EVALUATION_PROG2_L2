package school.hei;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class HistoryNote {
    private double note;
    private Instant dateCreation;
    private String motif;
}
