package com.example.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	public List<Song> findAll();
	public List<Song> findByArtist(String artist);
}
