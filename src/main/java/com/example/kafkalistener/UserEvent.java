package com.example.kafkalistener;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public final class UserEvent {
    private String name;
    private int age;
}

