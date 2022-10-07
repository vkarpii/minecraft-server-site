package ua.minecraftserversite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @Column(name = "role_id")
    private long id;
    @Column(name = "role_name")
    private String name;
}
