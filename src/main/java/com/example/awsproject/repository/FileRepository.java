package com.example.awsproject.repository;

import com.example.awsproject.model.Event;
import com.example.awsproject.model.IFile;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
/**
 * Service interface for class {@link  IFile}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
@Repository
public interface FileRepository extends R2dbcRepository<IFile,Long> {
}
