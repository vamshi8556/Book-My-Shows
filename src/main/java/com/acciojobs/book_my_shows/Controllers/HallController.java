package com.acciojobs.book_my_shows.Controllers;

import com.acciojobs.book_my_shows.Dtos.HallRequestDto;
import com.acciojobs.book_my_shows.Exceptions.UnAuthorizedException;
import com.acciojobs.book_my_shows.Exceptions.UserNotFoundException;
import com.acciojobs.book_my_shows.Services.HallService;
import com.acciojobs.book_my_shows.Services.UserService;
import com.acciojobs.book_my_shows.models.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Hall")
public class HallController {
    private HallService hallService;
    @Autowired
    public HallController(HallService hallService){
        this.hallService = hallService;
    }
    @PostMapping("/create")
    public ResponseEntity CreateHall(
            @RequestParam UUID theaterSysId,
            @RequestParam UUID theaterownersysid,
            @RequestBody HallRequestDto hallRequestDto
            ){
        HashMap<String, String> ExceptionMessage = new HashMap<>();
        try{
            Hall hall = hallService.CreateHall(theaterownersysid, theaterSysId, hallRequestDto);
            return new ResponseEntity(hall, HttpStatus.CREATED);
        }
        catch (UserNotFoundException e){
        ExceptionMessage.put("message", e.getMessage());
        return new ResponseEntity(ExceptionMessage, HttpStatus.UNAUTHORIZED);
        }
        catch (UnAuthorizedException e){
            ExceptionMessage.put("message", e.getMessage());
            return new ResponseEntity(ExceptionMessage, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ExceptionMessage.put("message", e.getMessage());
            return new ResponseEntity(ExceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
