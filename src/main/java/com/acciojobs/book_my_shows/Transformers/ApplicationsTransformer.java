package com.acciojobs.book_my_shows.Transformers;

import com.acciojobs.book_my_shows.Dtos.TheaterRequestDTO;
import com.acciojobs.book_my_shows.Dtos.UserRequestDto;
import com.acciojobs.book_my_shows.Utilities.SystemUtility;
import com.acciojobs.book_my_shows.models.Theater;
import com.acciojobs.book_my_shows.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Component
public class ApplicationsTransformer {
    public User TransformUserRequestDtoToUserModel(UserRequestDto userRequestDto, String UserType){
        return User.builder()
                .userID(SystemUtility.generateUserId())
                .userType(UserType)
                .phoneNumber(userRequestDto.getPhoneNumber())
                .userName(userRequestDto.getUserName())
                .password(userRequestDto.getPassword())
                .email(userRequestDto.getEmail())
                .address(userRequestDto.getAddress())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy("system")
                .updatedBy("system")
                .build();
    }
    public Theater TransformTheaterRequestDTOtoTheaterModel(TheaterRequestDTO theaterRequestDTO, User user){
        return Theater.builder()
                .theaterID(SystemUtility.generateUserId())
                .theaterName(theaterRequestDTO.getTheaterName())
                .halls(new ArrayList<>())
                .city(theaterRequestDTO.getCity())
                .state(theaterRequestDTO.getState())
                .country(theaterRequestDTO.getCountry())
                .address(theaterRequestDTO.getAddress())
                .owner(user)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy("system")
                .updatedBy("system")
                .build();
    }

}
