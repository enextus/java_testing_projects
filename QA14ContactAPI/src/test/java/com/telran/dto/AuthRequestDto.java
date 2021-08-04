package com.telran.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class AuthRequestDto {
    String login;
    String name;

}
