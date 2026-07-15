package com.acciojobs.book_my_shows.repositories;

import com.acciojobs.book_my_shows.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TheaterRepository extends JpaRepository<Theater, UUID>{
}
