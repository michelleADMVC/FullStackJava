package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Tag;
import com.example.app.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tagRepo;
	public TagService(TagRepository inject){
		this.tagRepo = inject;
	}
	public List<Tag> getAll() {
		return this.tagRepo.findAll();
	}
	public Tag getById(Long id){
		Optional<Tag> tag = this.tagRepo.findById(id);
		if (tag.isPresent()) {
			return tag.get();
		}else {
			return null;
		}
	}
	public void saveTag(Tag tag){
		this.tagRepo.save(tag);
	}
	public void newTag(String subject){
		this.tagRepo.save(new Tag(subject));
	}
}
