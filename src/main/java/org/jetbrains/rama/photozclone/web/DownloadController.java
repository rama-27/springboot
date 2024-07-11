package org.jetbrains.rama.photozclone.web;

import org.jetbrains.rama.photozclone.model.Photo;
import org.jetbrains.rama.photozclone.service.PhotoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {
    private final PhotoService photoService;
    public DownloadController(PhotoService photoService) {
        this.photoService = photoService;
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        byte[] data;
        Photo photo =photoService.find(id);
        if(photo == null) {
            throw new ResponseStatusException(HttpStatus.ACCEPTED);
        }
        data=photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));

        ContentDisposition build=ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data,headers, HttpStatus.OK);
    }
}
