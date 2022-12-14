package ua.minecraftserversite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "case",name = "opencase")
public class Case implements Buying{
    @Id
    @Column(name = "case_id")
    private long id;

    @Column(name = "case_name")
    private String name;
    @Column(name = "case_description")
    private String description;
    @Column(name = "case_cost")
    private int cost;

}
