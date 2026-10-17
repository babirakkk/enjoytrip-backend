package com.enjoytrip.tourism.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TourismService {

	@Value("${DATA_API_KEY}")
	String apiKey;
	RestClient restClient = RestClient.create();
	String baseUrl = "http://apis.data.go.kr/B551011/KorService2/areaBasedList2";

	public void getTourismList() {
		String result = restClient.get()
				.uri(baseUrl + "?serviceKey=" + apiKey + "&MobileOS=ETC&MobileApp=enjoytrip")
				.retrieve()
				.body(String.class);
		System.out.println(result);
	}
}
