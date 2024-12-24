package com.repository;

import com.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface ISongRepository extends CrudRepository<Song, Integer> {
}
