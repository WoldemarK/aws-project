package com.example.awsproject.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@ToString
@Table("files")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class IFile {
    @Id
    private Long id;
    private String location;
    private Status status;
}
