package com.acciojobs.book_my_shows.Controllers;

import com.acciojobs.book_my_shows.Dtos.TheaterRequestDTO;
import com.acciojobs.book_my_shows.Exceptions.UserNotFoundException;
import com.acciojobs.book_my_shows.Services.TheaterService;
import com.acciojobs.book_my_shows.models.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api/register")
public class TheaterController {
    private TheaterService theaterService;
    @Autowired
    public TheaterController(TheaterService theaterService){
        this.theaterService = theaterService;
    }

    @PostMapping("/createtheater")
    public ResponseEntity CreaterTheater(@RequestBody TheaterRequestDTO theaterRequestDTO,
                                         @RequestParam UUID usersysid){
        try{
            Theater theater = theaterService.CreaterTheater(theaterRequestDTO, usersysid);
            return new ResponseEntity(theater, HttpStatus.CREATED);
        }
        catch(UserNotFoundException e){
            HashMap<String, String> message = new HashMap<>();
            message.put("Message",e.getMessage());
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
    }
}
