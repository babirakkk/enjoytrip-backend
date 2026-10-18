package com.enjoytrip.tourism.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoytrip.tourism.application.TourismService;
import com.enjoytrip.tourism.dto.TourismResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tourism")
@Tag(name = "Tourism API", description = "한국관광공사 국문 관광정보 api를 호출해 결과를 받아오는 api")
public class TourismController {

	private final TourismService tourismService;

	@Operation(summary = "전체 관광지 데이터를 불러오고 DB에 저장하는 API")
	@PostMapping("/sync")
	public ResponseEntity<Void> saveAllTourismList() {
		tourismService.saveTourismList();
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "DB에 저장된 관광지 목록 조회")
	@GetMapping()
	public ResponseEntity<List<TourismResponse>> getAllTourism() {
		return ResponseEntity.ok(tourismService.getAllTourism());
	}
}
