package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Awards {
    private Integer wins;
    private Integer nominations;
    private String text;
}
