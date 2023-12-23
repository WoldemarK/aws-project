package com.example.awsproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Table("users")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString(exclude = "events")
public class IUser {

    @Id
    private Long id;
    private Status status;
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private boolean enabled;

    @Column("role")
    private IUserRole role;

//    @Transient
//    private List<Event> events;

    @CreatedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createAt;
    @LastModifiedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updateAt;
}
