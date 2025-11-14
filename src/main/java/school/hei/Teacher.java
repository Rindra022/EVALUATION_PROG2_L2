package school.hei;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Teacher extends User{
    private String speciality;

    public Teacher(int id, String lastName, String firstName, LocalDate birthDate, String email, String phoneNumber, String speciality) {
        super(id, lastName, firstName, birthDate, email, phoneNumber);
        this.speciality = speciality;
    }
}
