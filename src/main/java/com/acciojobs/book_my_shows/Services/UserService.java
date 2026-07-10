package com.acciojobs.book_my_shows.Services;

import com.acciojobs.book_my_shows.Dtos.UserRequestDto;
import com.acciojobs.book_my_shows.Transformers.ApplicationsTransformer;
import com.acciojobs.book_my_shows.Utilities.SystemUtility;
import com.acciojobs.book_my_shows.enums.UserType;
import com.acciojobs.book_my_shows.models.User;
import com.acciojobs.book_my_shows.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
