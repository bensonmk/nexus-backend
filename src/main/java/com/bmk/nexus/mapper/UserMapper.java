package com.bmk.nexus.mapper;

import com.bmk.nexus.dto.request.UserRequestDto;
import com.bmk.nexus.dto.response.UserResponseDto;
import com.bmk.nexus.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {



    User toEntity(UserRequestDto requestDto);

    UserResponseDto toResponseDto(User user);
}
