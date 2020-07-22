package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	List<Country> findAll();
	
	@Query("SELECT c FROM Country c JOIN c.languages l")
	List<Country> joinCountryAndLanguages();
	
	@Query(
		value=
		"SELECT countries.name, languages.language, languages.percentage\r\n" + 
		"FROM countries JOIN languages ON languages.country_code = countries.code \r\n" + 
		"WHERE language = 'slovene'\r\n" + 
		"ORDER BY languages.percentage DESC;", nativeQuery=true)
	List<Object[]> countriesSlovene();
	
	@Query("SELECT c FROM Country c JOIN c.cities ci GROUP BY ci.country ORDER BY count(c)")
	List<Country> countriesCities();
	
	@Query(
		value=
		"SELECT countries.name, cities.name as cityname, cities.population\r\n" + 
		"FROM countries JOIN cities ON cities.country_code = countries.code\r\n" + 
		"WHERE countries.name = 'mexico' AND cities.population > 500000\r\n" + 
		"ORDER BY cities.population DESC", nativeQuery=true)
	List<Object[]> citiesOfMexico();
	
	@Query(
			value="SELECT countries.name, languages.language,languages.percentage\r\n" + 
					"FROM countries JOIN languages ON languages.country_code = countries.code\r\n" + 
					"WHERE languages.percentage > 89\r\n" + 
					"ORDER BY languages.percentage DESC ", nativeQuery=true)
		List<Object[]> languagesMoreThan();
		
	@Query(
			value="SELECT countries.name, countries.population,surface_area\r\n" + 
					"FROM countries\r\n" + 
					"WHERE countries.population < 100000 AND countries.surface_area < 501\r\n" + 
					"ORDER BY surface_area DESC", nativeQuery=true)
	List<Object[]> lessThan501Surface();
}
