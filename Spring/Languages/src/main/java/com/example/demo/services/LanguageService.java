package com.example.demo.services;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.example.demo.models.Language;
import com.example.demo.repositories.LanguageRepository;
import java.util.Optional;
import java.util.List;

@Service
public class LanguageService {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(LanguageService.class); 
	LanguageRepository langRepo;
	public LanguageService(LanguageRepository inject) {
		langRepo = inject;
	}
	public List<Language> getAll(){
		return this.langRepo.findAll();
	}
	
	public Language getLanguage(Long id) {
		Optional<Language> lang = this.langRepo.findById(id);
		if (lang.isPresent()) {
			return lang.get();
		}else {
			return null;
		}
	}
	public void deleteById(Long id) {
		this.langRepo.deleteById(id);
	}
	public void save(Language lang){
		this.langRepo.save(lang);
	}
	public void newLanguage(String name, String creator, String version){
		Language newLang = new Language(name,creator,version);
		this.save(newLang);
	}
	public void updateLanguage(Long id, String name, String creator, String version){
		Language updatedLanguage = this.getLanguage(id);
		if (updatedLanguage != null) {
			updatedLanguage.setName(name);
			updatedLanguage.setCreator(creator);
			updatedLanguage.setCurrentVersion(version);
			this.save(updatedLanguage);
		}else {
			System.out.println("No editado");
		}
		
	}
	public void test(){
		for (int i = 0; i < 10; i++) {
			logger.info("Test language added to database");
			Language testLang = new Language("Java"+i, "God", "6."+1);
			this.save(testLang);
		}
	}
	
}
