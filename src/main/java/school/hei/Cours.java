package school.hei;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public class Cours {
    private int id;
    private String label;
    private int credits;
    private Teacher teacher;
}
