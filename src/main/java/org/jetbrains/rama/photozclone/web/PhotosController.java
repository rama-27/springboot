package org.jetbrains.rama.photozclone.web;

import org.jetbrains.rama.photozclone.model.Photo;
import org.jetbrains.rama.photozclone.service.PhotoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PhotosController {
    private final PhotoService photoService;
    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }





    @GetMapping("/")
    public String hello() {
        return "hello";
    }
    @GetMapping("/photos")
    public Iterable<Photo> getPhotos() {
        return photoService.values();
    }
    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable Integer id) {

        return photoService.find(id);

    }

    @PostMapping("/photos")
    public void add( @RequestPart("data") MultipartFile file) throws IOException {

        photoService.put(file.getOriginalFilename(), file.getBytes(),file.getContentType());


    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id) {
        photoService.remove(id);

    }



}
