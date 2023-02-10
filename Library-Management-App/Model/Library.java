package com.example.LibraryManagementApplication.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Library {
    private String name;
    private String address;
    private int number;
    private int faculties;
}
