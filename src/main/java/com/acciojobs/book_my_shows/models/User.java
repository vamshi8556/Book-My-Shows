package com.acciojobs.book_my_shows.models;

import lombok.*;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    private String userID;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String userType;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
