package org.jetbrains.rama.photozclone.service;

import org.jetbrains.rama.photozclone.model.Photo;
import org.jetbrains.rama.photozclone.repository.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PhotoService {

    private final PhotosRepository photosRepository;
    public PhotoService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public Iterable<Photo> values() {
        return photosRepository.findAll();
    }

    public Photo find(Integer id) {
        Photo photo=photosRepository.findById(id).orElse(null);
        if(photo==null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return photo;
    }

    public void put(String id, byte[] data, String contentType) {
        Photo photo=new Photo();
        photo.setFileName(id);
        photo.setData(data);
        photo.setContentType(contentType);
        photosRepository.save(photo);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);

    }
}
