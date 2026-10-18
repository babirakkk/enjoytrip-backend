package com.enjoytrip.tourism.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enjoytrip.tourism.domain.Tourism;

public interface TourismRepository extends JpaRepository<Tourism, Long> {
	List<Tourism> findAllByContentIdIn(List<Long> contentIds);
}
