package com.acciojobs.book_my_shows.repositories;

import com.acciojobs.book_my_shows.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface HallRepository extends JpaRepository<Hall, UUID> {
}
