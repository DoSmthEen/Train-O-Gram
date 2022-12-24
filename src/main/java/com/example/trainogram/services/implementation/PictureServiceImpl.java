package com.example.trainogram.services.implementation;

import com.example.trainogram.dao.repositories.PictureMetadataRepository;
import com.example.trainogram.exceptions.InvalidFileException;
import com.example.trainogram.exceptions.UserNotFoundException;
import com.example.trainogram.models.PictureMetaData;
import com.example.trainogram.models.PictureUsages;
import com.example.trainogram.models.User;
import com.example.trainogram.services.PictureService;
import com.example.trainogram.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.InvalidFileNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {
    
    @Value("${file.upload-dir}")
    private String uploadDirectory;
    @Value("${file.path-prefix}")
    private String filePathPrefix;
    @Autowired
    private final PictureMetadataRepository pictureMetadataRepository;
    private final Environment environment;
    private final UserService userService;


    public List<PictureMetaData> uploadPicture(List<MultipartFile> pictures, String username, PictureUsages pictureUsage) throws InvalidFileException, InvalidFileNameException,
            UsernameNotFoundException, UnknownHostException {

        String usage = pictureUsage.toString();

        String port = "8080";
        String hostName = InetAddress.getLocalHost().getHostName();
        File file = new File(uploadDirectory + "/" + username + "/" + usage);
        file.mkdirs();

        List<PictureMetaData> picturesMetaData = new ArrayList<>();

        for(MultipartFile picture : pictures){
            String imageName = StringUtils.cleanPath(Objects.requireNonNull(picture.getOriginalFilename()));

            try {
                if(picture.isEmpty()){
                    throw new InvalidFileException("Failed to store empty picture " + imageName);
                }

                if(imageName.contains("..")){
                    throw new InvalidFileNameException(picture.getName(),
                            "Cannot store picture with relative path outside current directory "
                                    + imageName);
                }

                String extention = FilenameUtils.getExtension(imageName);
                String newImageName = UUID.randomUUID() + "." + extention;

                try(InputStream inputStream = picture.getInputStream()) {

                    Files.copy(inputStream, file.toPath().resolve(newImageName),
                            StandardCopyOption.REPLACE_EXISTING);
                }

                String imageUrl = String.format("https://%s:%s/%s/%s/%s",
                        hostName, port, filePathPrefix, username, newImageName);


                PictureMetaData pictureMetaData = new PictureMetaData(
                        userService.getUserByUsername(username),
                        pictureUsage,
                        newImageName,
                        imageUrl,
                        picture.getContentType());

                picturesMetaData.add(pictureMetaData);

                pictureMetadataRepository.save(pictureMetaData);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return picturesMetaData;

    }

    @Override
    public void deleteAllUserDirectories(String id) throws UserNotFoundException {
        User user = userService.getUserById(id);
        try {
            File file = new File(uploadDirectory + "/" + user.getUsername());
            FileUtils.forceDelete(file);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAllPictureMetadataRelatedToUser(String id) {
        pictureMetadataRepository.deleteAllByAuthorId(id);
    }
}
