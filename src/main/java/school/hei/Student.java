package school.hei;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Student extends User{
    private final String group;
    private Tutor tutor;

    public Student(int id, String lastName, String firstName, LocalDate birthDate, String email, String phoneNumber, String group, Tutor tutor) {
        super(id, lastName, firstName, birthDate, email, phoneNumber);
        this.group = group;
        this.tutor = tutor;
    }


}
