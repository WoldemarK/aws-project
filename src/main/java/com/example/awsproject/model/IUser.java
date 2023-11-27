package com.example.awsproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@ToString
@Table("users")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class IUser {
    @Id
    private Long id;
    private Status status;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private IUserRole role;

//    @ToString.Exclude
//    private List<Event> Events;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createAt;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updateAt;
}
