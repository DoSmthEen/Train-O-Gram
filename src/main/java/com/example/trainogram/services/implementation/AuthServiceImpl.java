package com.example.trainogram.services.implementation;

import com.example.trainogram.dao.repositories.UserRepository;
import com.example.trainogram.dto.UserRequest;
import com.example.trainogram.exceptions.UserNotFoundException;
import com.example.trainogram.exceptions.UsernameNotUniqueException;
import com.example.trainogram.mappers.UserMapper;
import com.example.trainogram.models.PictureMetaData;
import com.example.trainogram.models.PictureUsages;
import com.example.trainogram.services.AuthService;
import com.example.trainogram.models.User;
import com.example.trainogram.services.PictureService;
import com.example.trainogram.services.PostService;
import com.example.trainogram.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.UnknownHostException;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final UserMapper userMapper;
    private final PictureService pictureService;
    private final PasswordEncoder passwordEncoder;
    private final PostService postService;
    public User signUp(UserRequest userRequest) throws UsernameNotUniqueException {

        String username = userRequest.getUsername();
        if (userRepository.findByUsername(username) == null) {
            User user = userMapper.mapUserRequestToUser(userRequest);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userService.saveUser(user);

        }
        throw new UsernameNotUniqueException(username);
    }
    @Override
    public String updateProfilePicture(MultipartFile avatar, String username) throws UnknownHostException {

        List<PictureMetaData> picture = pictureService.uploadPicture(List.of(avatar), username, PictureUsages.avatars);
        User user = userService.getUserByUsername(username);
        user.setAvatarUrl(picture.get(0).getUri());
        userService.saveUser(user);

        return user.getAvatarUrl();

    }
    @Override
    public void deleteAccount(String id) throws UserNotFoundException {

        pictureService.deleteAllUserDirectories(id);
        postService.deleteAllPostsRelatedToUser(id);
        pictureService.deleteAllPictureMetadataRelatedToUser(id);
        userService.deleteUserById(id);

    }
}