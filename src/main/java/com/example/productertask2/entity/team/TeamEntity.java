package com.example.productertask2.entity.team;

import com.example.productertask2.entity.BaseEntity;
import com.example.productertask2.entity.player.PlayerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team")
public class TeamEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "teamEntity",cascade = CascadeType.ALL)
    private List<PlayerEntity> playerEntities;
}
