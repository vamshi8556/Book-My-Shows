package com.acciojobs.book_my_shows.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booked-Seats")
public class BookedSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sysid;
    @Column(unique = true, nullable = false)
    private String seatID;
    private String bookingID;
    @ManyToOne
    private Show show;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
