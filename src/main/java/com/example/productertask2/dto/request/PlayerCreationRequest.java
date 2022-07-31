package com.example.productertask2.dto.request;

import com.example.productertask2.enums.PlayerPosition;
import lombok.Data;

@Data
public class PlayerCreationRequest {
    private Long teamId;
    private String name;
    private String surname;
    private PlayerPosition position;
}
