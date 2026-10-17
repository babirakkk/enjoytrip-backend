package com.enjoytrip.tourism.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.enjoytrip.tourism.dao.TourismRepository;
import com.enjoytrip.tourism.domain.Tourism;
import com.enjoytrip.tourism.dto.TourismApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TourismService {

	@Value("${DATA_API_KEY}")
	private String apiKey;
	private RestClient restClient = RestClient.create();
	private final String baseUrl = "http://apis.data.go.kr/B551011/KorService2/areaBasedList2";
	private final TourismRepository tourismRepository;

	public void getTourismList() {
		TourismApiResponse result = restClient.get()
				.uri(baseUrl + "?serviceKey=" + apiKey + "&MobileOS=ETC&MobileApp=enjoytrip&_type=json")
				.retrieve()
				.body(TourismApiResponse.class);

		List<Tourism> tourList = result.response().body().items().item().stream()
				.map(TourismApiResponse.Item::toEntity)
				.filter(tourism -> !tourismRepository.existsByContentId(tourism.getContentId()))
				.toList();
		tourismRepository.saveAll(tourList);
	}
}
