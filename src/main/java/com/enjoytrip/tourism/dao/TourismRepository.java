package com.enjoytrip.tourism.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enjoytrip.tourism.domain.Tourism;

public interface TourismRepository extends JpaRepository<Tourism, Long> {
}
