package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "posts")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_generator")
    @SequenceGenerator(name = "post_generator", sequenceName = "post_seq", allocationSize = 1)
    private Long id;
    private String imageURl;
    @Column(length = 1000)
    private String description;
    private LocalDate createdAt;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private User owner;

    @PrePersist @PreUpdate
    private void onCreate() {
        this.createdAt = LocalDate.now();
    }

}
