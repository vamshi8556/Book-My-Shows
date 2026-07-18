package com.acciojobs.book_my_shows.Services;

import com.acciojobs.book_my_shows.Dtos.HallRequestDto;
import com.acciojobs.book_my_shows.Exceptions.UnAuthorizedException;
import com.acciojobs.book_my_shows.Transformers.ApplicationsTransformer;
import com.acciojobs.book_my_shows.models.Hall;
import com.acciojobs.book_my_shows.models.Theater;
import com.acciojobs.book_my_shows.models.User;
import com.acciojobs.book_my_shows.repositories.HallRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.UUID;

@Slf4j
@Service

public class HallService {
    private UserService userService;
    private  TheaterService theaterService;
    private HallRepository hallRepository;
    private ApplicationsTransformer applicationsTransformer;
    public HallService(UserService userService, TheaterService theaterService, HallRepository hallRepository, ApplicationsTransformer applicationsTransformer){
        this.userService = userService;
        this.theaterService = theaterService;
        this.hallRepository = hallRepository;
        this.applicationsTransformer = applicationsTransformer;
    }
    public Hall CreateHall(UUID theaterOwnerSysId, UUID theaterSysid, HallRequestDto hallRequestDto) throws InvalidAttributesException {
        User user = userService.verifyTheaterOwner(theaterOwnerSysId);
        Theater theater = theaterService.verifyTherater(theaterSysid);
        if(!user.getSysid().equals(theater.getOwner().getSysid())){
            throw  new UnAuthorizedException("User does not own the theater");
        }
        Hall hall = applicationsTransformer.TransformHallDtotoHallModel(hallRequestDto, theater);
        hallRepository.save(hall);
        return hall;
    }
}
