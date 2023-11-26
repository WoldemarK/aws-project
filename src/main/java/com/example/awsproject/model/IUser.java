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
    @Column("status")
    private Status status;
    @Column("username")
    private String username;
    @Column("password")
    private String password;
    @Column("firstName")
    private String firstName;
    @Column("lastName")
    private String lastName;
    @Column("enabled")
    private boolean enabled;

    @Column("rol")
    private IUserRole role;

    @ToString.Exclude
    private List<IEvent> IEvents;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createAt;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updateAt;
}
