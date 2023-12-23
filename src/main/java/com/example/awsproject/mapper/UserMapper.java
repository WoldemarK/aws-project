package com.example.awsproject.mapper;

import com.example.awsproject.dto.IUserDto;
import com.example.awsproject.model.IUser;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
/**
 *  Interface for {@link UserMapper} class
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    IUserDto map(IUser user);
    @InheritConfiguration
    IUser map(IUserDto userDto);
}
