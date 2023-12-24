package com.example.awsproject.dto;

import com.example.awsproject.model.IUser;
import com.example.awsproject.model.IUserRole;
import com.example.awsproject.model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;

/**
 * class {@link IUser}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IUserDto {

    private Long id;
    private Status status;
    private String username;

    private String firstName;
    private String lastName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private boolean enabled;
    private IUserRole role;
    private LocalDate createAt;
    private LocalDate updateAt;
}
