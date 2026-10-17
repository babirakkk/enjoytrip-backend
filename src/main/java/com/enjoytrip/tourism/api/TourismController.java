package com.enjoytrip.tourism.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoytrip.tourism.application.TourismService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tourism")
@Tag(name = "Tourism API", description = "한국관광공사 국문 관광정보 api를 호출해 결과를 받아오는 api")
public class TourismController {

	private final TourismService tourismService;

	@Operation(summary = "전체 관광지 데이터를 불러오는 API")
	@GetMapping()
	public ResponseEntity<Void> getAllTourismList() {
		tourismService.getTourismList();
		return ResponseEntity.ok().build();
	}
}
