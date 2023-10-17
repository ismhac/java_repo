package com.example.demo_01.dtos;

import javax.management.relation.Role;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String email;
    private String password;

    // @Enumerated(EnumType.STRING)
    // private Role role;
}
