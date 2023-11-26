package com.example.awsproject.model;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@ToString
@Table("events")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class IEvent {

    private Long id;
    private IUser users;
    private IFile file;
    private Status status;
}
