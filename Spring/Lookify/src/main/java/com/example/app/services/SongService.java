package com.example.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Song;
import com.example.app.repository.SongRepository;
@Service
public class SongService {
	private SongRepository songRepo;
	
	public SongService(SongRepository inject) {
		this.songRepo = inject; 
	}
	public List<Song> getAllSongs(){
		return this.songRepo.findAll();
	}
	public List<Song> getSongsByArtist(String artist){
		return this.songRepo.findByArtist(artist);
	}
	public void saveSong(Song song){
		this.songRepo.save(song);
	}
	public Song getSong(Long id){
		Optional<Song> song = this.songRepo.findById(id);
		if (song.isPresent()) {
			return song.get() ;
		}else {
			return null;
		}
				
	}
	public void deleteSong(Long id){
		this.songRepo.deleteById(id);
	}
	public void test() {
		for (int i = 0; i < 10; i++) {
			Song newSong = new Song("CancionDeMetalGenerica"+i,"Lamb of dios",1);
			this.saveSong(newSong);
		}
	}
	
	public ArrayList<Song> getTopTen() {
		
		ArrayList<Song> songs = new ArrayList<Song>();
		
		List<Song> sortSongs = this.getAllSongs();
		Collections.sort(sortSongs);
		for (int i = 0; i < 10 ; i++) {
			songs.add(sortSongs.get(i));
		}
		return songs;
	}
	

	
}
