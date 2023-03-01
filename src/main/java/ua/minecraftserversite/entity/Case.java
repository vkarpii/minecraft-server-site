package ua.minecraftserversite.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
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
