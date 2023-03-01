package ua.minecraftserversite.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname")
    private String nickname;
    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "perm_id")
    private Permission permission;
    public User(String nickname){
        this.nickname = nickname;
    }

}