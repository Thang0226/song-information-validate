package com.service;

import com.model.Song;

import java.util.Optional;

public interface ISongService {
    Iterable<Song> findAll();

    void save(Song song);

    Optional<Song> findById(Integer id);
}
