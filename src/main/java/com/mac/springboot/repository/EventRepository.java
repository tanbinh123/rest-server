package com.mac.springboot.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.mac.springboot.domain.Event;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

	List<Event> findByType(@Param("type") Event.Type type);

}
