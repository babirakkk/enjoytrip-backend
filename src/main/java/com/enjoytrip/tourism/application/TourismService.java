package com.enjoytrip.tourism.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.enjoytrip.tourism.dao.TourismRepository;
import com.enjoytrip.tourism.domain.Tourism;
import com.enjoytrip.tourism.dto.TourismApiResponse;
import com.enjoytrip.tourism.dto.TourismResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TourismService {

	@Value("${DATA_API_KEY}")
	private String apiKey;
	@Value("${external.tour-api.base-url}")
	private String baseUrl;

	private final RestClient restClient = RestClient.create();
	private final TourismRepository tourismRepository;

	public void saveTourismList() {
		int pageNo = 1;
		int numOfRows = 100;

		while (true) {
			int currentPage = pageNo; // lambda에서 참조하기 위해서는 effectively final이어야 함
			log.info("관광정보 {}페이지 요청 시작", currentPage);
			long startedAt = System.currentTimeMillis();
			TourismApiResponse result = restClient.get()
					.uri(baseUrl, builder -> builder
							.path("/areaBasedList2")
							.queryParam("serviceKey", apiKey)
							.queryParam("MobileOS", "ETC")
							.queryParam("MobileApp", "enjoytrip")
							.queryParam("_type", "json")
							.queryParam("pageNo", currentPage)
							.queryParam("numOfRows", numOfRows)
							.build())
					.retrieve()
					.body(TourismApiResponse.class);
			long receivedAt = System.currentTimeMillis();
			log.info("외부 API 소요 시간: {}ms", receivedAt - startedAt);

			TourismApiResponse.Body body = result.response().body();

			List<Tourism> tourList = body.items().item().stream()
					.map(TourismApiResponse.Item::toEntity)
					.filter(tourism -> !tourismRepository.existsByContentId(tourism.getContentId()))
					.toList();
			tourismRepository.saveAll(tourList);
			log.info("DB 처리 소요 시간: {}ms",
					System.currentTimeMillis() - receivedAt);

			if ((long) body.pageNo() * body.numOfRows() >= body.totalCount()) {
				break;
			}
			pageNo++;
		}
	}

	public List<TourismResponse> getAllTourism() {
		return tourismRepository.findAll().stream()
				.map(TourismResponse::from)
				.toList();
	}
}
