package ua.minecraftserversite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "permission")
public class Permission {
    @Id
    @Column(name = "permission_id")
    private long id;
    @Column(name = "perm_name")
    private String name;
    @Column(name = "perm_description")
    private String description;

}
