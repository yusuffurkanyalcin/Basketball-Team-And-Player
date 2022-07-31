package com.example.productertask2.entity.player;

import com.example.productertask2.entity.BaseEntity;
import com.example.productertask2.entity.team.TeamEntity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player")
public class PlayerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(
            name = "team_id",
            referencedColumnName = "id")
    private TeamEntity teamEntity;

    public PlayerEntity(
            String name,
            String surname,
            String position,
            TeamEntity teamEntity
    ){
        this.name       = name;
        this.surname    = surname;
        this.position   = position;
        this.teamEntity = teamEntity;
    }
}
