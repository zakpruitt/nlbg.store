package com.nlbg.store.repository;

import com.nlbg.store.domain.Photo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
