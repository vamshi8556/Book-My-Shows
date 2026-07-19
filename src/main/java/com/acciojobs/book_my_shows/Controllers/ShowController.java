package com.acciojobs.book_my_shows.Controllers;

import com.acciojobs.book_my_shows.Dtos.ShowRequestDto;
import com.acciojobs.book_my_shows.Exceptions.UnAuthorizedException;
import com.acciojobs.book_my_shows.Exceptions.UserNotFoundException;
import com.acciojobs.book_my_shows.Services.ShowService;
import com.acciojobs.book_my_shows.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Show")
public class ShowController {
    private ShowService showService;
    @Autowired
    public ShowController(ShowService showService){
        this.showService = showService;
    }
    @PostMapping("/create")
    public ResponseEntity CreateShows(
            @RequestParam UUID usersysID,
            @RequestParam UUID hallsysid,
            @RequestBody ShowRequestDto showRequestDto){
        HashMap<String, String> exceptionmessage = new HashMap<>();
        try{
            return new ResponseEntity(showService.Createshow(showRequestDto, usersysID, hallsysid), HttpStatus.CREATED);
        }
        catch (UserNotFoundException e){
            exceptionmessage.put("message", e.getMessage());
            return new ResponseEntity(exceptionmessage, HttpStatus.UNAUTHORIZED);
        }
        catch (UnAuthorizedException e){
            exceptionmessage.put("message", e.getMessage());
            return new ResponseEntity(exceptionmessage, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            exceptionmessage.put("message", e.getMessage());
            return new ResponseEntity(exceptionmessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
