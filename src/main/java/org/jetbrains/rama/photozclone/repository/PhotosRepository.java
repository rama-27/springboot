package org.jetbrains.rama.photozclone.repository;

import org.jetbrains.rama.photozclone.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PhotosRepository extends CrudRepository<Photo, Integer> {
}
