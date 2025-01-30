package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enums.Gender;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "profile_seq", allocationSize = 1)
    private Long id;
    private String fullName;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String biography;

    public Profile(String fullName, LocalDate birthDate, Gender gender, String biography) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.biography = biography;

    }
}
