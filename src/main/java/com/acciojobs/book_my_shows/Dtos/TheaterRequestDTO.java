package com.acciojobs.book_my_shows.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterRequestDTO {
    private String theaterName;
    private String city;
    private String state;
    private String country;
    private String address;
}
