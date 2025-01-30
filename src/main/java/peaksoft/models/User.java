package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    private String username;
    private String email;
    private String password;
    @OneToOne(cascade = {PERSIST, REMOVE, MERGE, DETACH}, fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(mappedBy = "owner", cascade = {REMOVE})
    private List<Post> posts;

    // OneToOne.  EAGER
    // ManyToOne  EAGER
    // OneToMany  LAZY
    // ManyToMany LAZY

}
