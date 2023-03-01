package ua.minecraftserversite.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "permission")
public class Permission implements Buying{
    @Id
    @Column(name = "perm_id")
    private long id;
    @Column(name = "perm_name")
    private String name;
    @Column(name = "perm_description")
    private String description;
    @Column(name = "perm_cost")
    private int cost;

}
