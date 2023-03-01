package ua.minecraftserversite.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "history")
public class History {
    @Id
    @Column(name = "history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "history_desc")
    private String description; //CASE:<NAME>#<NUMBER>    PERMISSION:<NAME>#<NUMBER>

}
