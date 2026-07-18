package com.acciojobs.book_my_shows.repositories;

import com.acciojobs.book_my_shows.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HallRepository extends JpaRepository<Hall, UUID> {
}
