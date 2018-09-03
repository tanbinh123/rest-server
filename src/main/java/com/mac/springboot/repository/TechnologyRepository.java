package com.mac.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.mac.springboot.domain.Technology;

public interface TechnologyRepository extends PagingAndSortingRepository<Technology, Long> {

	@Query("SELECT t FROM Technology t where t.name = :name")
	Optional<Technology> findOneByName(@Param("name") String name);

	@Query("SELECT t FROM Technology t where t.name in :name")
	Optional<List<Technology>> findByName(@Param("name") List<String> name);
}
