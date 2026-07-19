package com.acciojobs.book_my_shows.Services;

import com.acciojobs.book_my_shows.Dtos.ShowRequestDto;
import com.acciojobs.book_my_shows.Exceptions.UnAuthorizedException;
import com.acciojobs.book_my_shows.Transformers.ApplicationsTransformer;
import com.acciojobs.book_my_shows.Utilities.SystemUtility;
import com.acciojobs.book_my_shows.models.Hall;
import com.acciojobs.book_my_shows.models.Show;
import com.acciojobs.book_my_shows.models.User;
import com.acciojobs.book_my_shows.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ShowService {
    private UserService userService;
    private HallService hallService;
    private ShowRepository showRepository;
    private ApplicationsTransformer applicationsTransformer;
    @Autowired
    public ShowService(UserService userService, HallService hallService, ShowRepository showRepository, ApplicationsTransformer applicationsTransformer){
        this.userService = userService;
        this.hallService = hallService;
        this.showRepository = showRepository;
        this.applicationsTransformer = applicationsTransformer;
    }
    public boolean isoverlapping(List<Show> shows, Long StartTime, Long EndTime){
        Collections.sort(shows);
        for(Show show : shows){
            if(show.getEndTimeInSeconds() >= StartTime){
                return true;
            }
        }
        return false;
    }
    public Show Createshow(ShowRequestDto showRequestDto, UUID usersysid, UUID hallsysid) throws InvalidAttributesException {
        User user = userService.verifyTheaterOwner(usersysid);
        Hall hall = hallService.verifyHall(hallsysid);
        if(!hall.getTheater().getOwner().getSysid().equals(user.getSysid())){
            throw  new UnAuthorizedException("User is not allowed to create show in this hall");
        }
        LocalDateTime startTime = showRequestDto.getStartTime();
        Long StartTimeInSeconds = SystemUtility.Convertshowtimeintoseconds(startTime);
        LocalDateTime endTime = showRequestDto.getEndTime();
        Long EndTimeInSeconds = SystemUtility.Convertshowtimeintoseconds(endTime);
        List<Show> shows = showRepository.findByHall(hall);
        boolean istrue = this.isoverlapping(shows, StartTimeInSeconds, EndTimeInSeconds);
        if(istrue){
            throw  new IllegalArgumentException("User is not allowed to create show");
        }
        Show show = applicationsTransformer.TransformShowRequestDtoToShowModel(showRequestDto, hall, user,StartTimeInSeconds, EndTimeInSeconds);
        showRepository.save(show);
        return show;
    }
}
