package com.acciojobs.book_my_shows.Dtos;

import com.acciojobs.book_my_shows.models.Theater;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HallRequestDto {
    private String hallName;
    private String rowRange;
    private String seatCapacity;
}
