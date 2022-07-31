package com.example.productertask2.dto.player;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private String name;
    private String surname;
    private String team;
    private String position;
    private String createdAt;
}
