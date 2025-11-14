package school.hei;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Tutor extends User{
    private String descRelationStudent;

    public Tutor(int id, String lastName, String firstName, LocalDate birthDate, String email, String phoneNumber, String description) {
        super(id, lastName, firstName, birthDate, email, phoneNumber);
        this.descRelationStudent = descRelationStudent;
    }
}
