package com.acciojobs.book_my_shows.repositories;

import com.acciojobs.book_my_shows.models.Hall;
import com.acciojobs.book_my_shows.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShowRepository extends JpaRepository<Show, UUID>{
    @Query (value = "select * from shows where hall_sysid = :hallsysid", nativeQuery = true)
    public List<Show> getallshowsByhallsysid(@Param("hallsysid") String hallsysid);
    public List<Show> findByHall(Hall hall);
}
