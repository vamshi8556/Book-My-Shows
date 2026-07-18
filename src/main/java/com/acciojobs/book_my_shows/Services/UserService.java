package com.acciojobs.book_my_shows.Services;

import com.acciojobs.book_my_shows.Dtos.UserRequestDto;
import com.acciojobs.book_my_shows.Exceptions.UserNotFoundException;
import com.acciojobs.book_my_shows.Transformers.ApplicationsTransformer;
import com.acciojobs.book_my_shows.Utilities.SystemUtility;
import com.acciojobs.book_my_shows.enums.UserType;
import com.acciojobs.book_my_shows.models.User;
import com.acciojobs.book_my_shows.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private ApplicationsTransformer applicationTransformer;
    private UserRepository userRepository;
    @Autowired
    public UserService (ApplicationsTransformer applicationsTransformer, UserRepository userRepository){
        this.applicationTransformer = applicationsTransformer;
        this.userRepository = userRepository;
    }

    public User registerOwner(UserRequestDto userRequestDto){
        User user = applicationTransformer.TransformUserRequestDtoToUserModel(userRequestDto, UserType.OWNER.toString());
        this.userRepository.save(user);
        return user;
    }
    public User registerCustomer(UserRequestDto userRequestDto){
        User user = applicationTransformer.TransformUserRequestDtoToUserModel(userRequestDto, UserType.CUSTOMER.toString());
        this.userRepository.save(user);
        return user;
    }
    public User verifyTheaterOwner(UUID usersysid) throws InvalidAttributesException{
        Optional<User> user = userRepository.findById(usersysid);
        if(user.isEmpty()){
            throw new UserNotFoundException("User does not exist");
        }
        if(!user.get().getUserType().equals(UserType.OWNER.toString())){
            throw new InvalidAttributesException("Invalid Id Passed");
        }
        return user.get();
    }
}
