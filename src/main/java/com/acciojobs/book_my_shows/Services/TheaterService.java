package com.acciojobs.book_my_shows.Services;

import com.acciojobs.book_my_shows.Dtos.TheaterRequestDTO;
import com.acciojobs.book_my_shows.Exceptions.UserNotFoundException;
import com.acciojobs.book_my_shows.Transformers.ApplicationsTransformer;
import com.acciojobs.book_my_shows.models.Theater;
import com.acciojobs.book_my_shows.models.User;
import com.acciojobs.book_my_shows.repositories.TheaterRepository;
import com.acciojobs.book_my_shows.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.Optional;
import java.util.UUID;

@Service
public class TheaterService {
    private ApplicationsTransformer applicationsTransformer;
    private UserRepository userRepository;
    private TheaterRepository theaterRepository;
    @Autowired
    public TheaterService(UserRepository userRepository, ApplicationsTransformer applicationsTransformer, TheaterRepository theaterRepository){
        this.userRepository= userRepository;
        this.applicationsTransformer = applicationsTransformer;
        this.theaterRepository = theaterRepository;
    }
    public Theater CreaterTheater(TheaterRequestDTO theaterRequestDTO, UUID Usersysid){
        User user = userRepository.findById(Usersysid).orElse(null);
        if(user == null){
            throw new UserNotFoundException(String.format("User with id %s does not exist", Usersysid.toString()));
        }
        Theater theater = applicationsTransformer.TransformTheaterRequestDTOtoTheaterModel(theaterRequestDTO, user);
        theaterRepository.save(theater);
        return theater;
    }
    public Theater verifyTherater(UUID theatersysid)throws InvalidAttributesException{
        Optional<Theater> theater = theaterRepository.findById(theatersysid);
        if(theater.isEmpty()){
            throw new InvalidAttributesException("invalid user details");
        }
        return theater.get();
    }
}
