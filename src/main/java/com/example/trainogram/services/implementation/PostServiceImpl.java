package com.example.trainogram.services.implementation;

import com.example.trainogram.dao.entities.PostEntity;
import com.example.trainogram.dao.repositories.PostRepository;
import com.example.trainogram.dao.repositories.UserRepository;
import com.example.trainogram.dto.PostRequest;
import com.example.trainogram.exceptions.PostNotFoundException;
import com.example.trainogram.exceptions.UserNotFoundException;
import com.example.trainogram.mappers.PostMapper;
import com.example.trainogram.mappers.UserMapper;
import com.example.trainogram.models.*;
import com.example.trainogram.services.PictureService;
import com.example.trainogram.services.PostService;
import com.example.trainogram.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final PictureService pictureService;
    private final PostMapper postMapper;
    private final UserMapper userMapper;


    @Override
    public Post createPost(PostRequest postRequest, String username) throws UnknownHostException {

        List<MultipartFile> images = postRequest.getPictures();
        User user = userService.getUserByUsername(username);

        if (images == null){
            return postRepository.save(postMapper.mapPostRequestToPost(postRequest));
        }

        Post post = postMapper.mapPostRequestToPost(postRequest);
        List<String> pictureUrls = new ArrayList<>();

        List<PictureMetaData> pictureMetaData = pictureService.uploadPicture(images, username, PictureUsages.posts);
        pictureMetaData.forEach(imageMetaData -> pictureUrls.add(imageMetaData.getUri()));

        post.setAuthor(userMapper.mapUserToUserEntity(user));
        post.setPicturesUrls(pictureUrls);

        postRepository.save(post);

        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(String postId) throws PostNotFoundException {
        return postRepository.findById(postId).orElseThrow(
                () -> new PostNotFoundException(postId)
        );
    }

    @Override
    public List<Post> getAllPostsByAuthorUsername(String username) {
        return postRepository.findAllByAuthorUsername(username);
    }



    @Override
    public List<Post> getAllRecommendations(String username) {
        return getAllPostsByAuthorUsername(username).stream()
                .flatMap(post -> post.getComments().stream())
                .map(Comment::getAuthor)
                .flatMap(commentAuthor -> getAllPostsByAuthorUsername(commentAuthor.getId()).stream().limit(5))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllPostsRelatedToUser(String id) {
        postRepository.deleteAllByAuthorId(id);
    }

    @Override
    public void getAllPostsByAuthorId(String id) throws UserNotFoundException {
        if(userRepository.existsById(id)){
            postRepository.deleteAllByAuthorId(id);
        }
        else {
            throw new UserNotFoundException(id);
        }
    }
    @Override
    public Post updatePost(PostRequest postRequest, String username) throws PostNotFoundException, UnknownHostException {

        Post post = getPostById(postRequest.getId());
        String authorUsername = post.getAuthor().getUsername();

        if (Objects.equals(authorUsername, username)){
            post.setCaption(postRequest.getCaption());
            List<String> picturesUrls = new ArrayList<>();
            pictureService.uploadPicture(postRequest.getPictures(), username, PictureUsages.posts)
                    .forEach(pictureMetaData -> picturesUrls.add(pictureMetaData.getUri()));
            post.setPicturesUrls(picturesUrls);
            return post;
        }
        throw new AccessDeniedException("User " + username +
                " has no access to update posts of user " + authorUsername);
    }

    @Override
    public void deletePost(String id) {
        postRepository.deleteById(id);
    }


}

//⠀⢳⠀⠀⣼⣿⣿⣿⣿⣿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡁
//⢰⠆⠁⠠⣿⣿⡁⠀⠀⠀⠀⠀⠀⠈⠙⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿
//⣾⢠⠀⠀⢻⣿⣿⣦⣀⠀⠠⣀⡒⠀⠀⠀⠀⣸⣿⡇⠀⠀⠀⡀⠈⡈
//⢨⣿⡄⠀⠘⣿⣿⣿⣿⣷⣶⣶⣶⣦⣶⣶⣶⣿⣿⣷⣤⣄⣰⣧⣴⡇
//⠈⠻⠇⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁
//     ⢸⣿⣿⣿⣿⣿⣿⣿⡟⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟
//     ⠸⣿⣿⣿⣿⣿⣿⣿⣿⠀⠉⠉⠻⠿⣿⣿⣿⣿⣿⠃
//      ⠻⣿⣿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣿⣿⣿⣿⣿⡟
//       ⠘⢿⣿⣟⠹⠟⠛⠛⠛⠛⠟⠛⠿⢿⣿⡟
//         ⠉⠑⠈⠛⠓⠿⠶⠶⠶⠿⣶⠶