package com.acciojobs.book_my_shows.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shows")
@Builder
public class Show implements Comparable<Show>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private UUID sysid;
    private String showID;
    private Double showPrice;
    private String movieName;
    @ManyToOne
    private Hall hall;
    private Long StartTimeInSeconds;
    private Long EndTimeInSeconds;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    public int compareTo (Show b){
        return Long.compare(this.StartTimeInSeconds, b.StartTimeInSeconds);
    }
}
