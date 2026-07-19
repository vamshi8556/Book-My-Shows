package com.acciojobs.book_my_shows.Dtos;

import com.acciojobs.book_my_shows.models.Hall;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowRequestDto {
    private Double showPrice;
    private String movieName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
