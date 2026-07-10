package com.acciojobs.book_my_shows.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String userType;
    private String address;
}
