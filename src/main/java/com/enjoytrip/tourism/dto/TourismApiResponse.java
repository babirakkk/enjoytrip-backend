package com.enjoytrip.tourism.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.enjoytrip.tourism.domain.Tourism;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TourismApiResponse(Response response) {

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record Response(
			Header header,
			Body body
	) {}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record Header(
			String resultCode,
			String resultMsg
	) {}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record Body(
			Items items,
			Integer numOfRows,
			Integer pageNo,
			Integer totalCount
	) {}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record Items(List<Item> item) {}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record Item(
			String contentid,
			String title,
			String addr1,
			String contenttypeid,
			String firstimage,
			String firstimage2,
			String mapx,
			String mapy,
			String mlevel,
			String tel,
			String zipcode,
			String lDongRegnCd,
			String lDongSignguCd,
			String lclsSystm1,
			String lclsSystm2,
			String lclsSystm3
	) {
		public Tourism toEntity() {
			return new Tourism(
					Long.valueOf(contentid),
					title,
					addr1,
					Long.valueOf(contenttypeid),
					firstimage,
					firstimage2,
					(mapx == null || mapx.isBlank()) ? null : new BigDecimal(mapx),
					(mapy == null || mapy.isBlank()) ? null : new BigDecimal(mapy),
					(mlevel == null || mlevel.isBlank()) ? null : Long.valueOf(mlevel),
					tel,
					zipcode,
					lDongRegnCd,
					lDongSignguCd,
					lclsSystm1,
					lclsSystm2,
					lclsSystm3,
					LocalDateTime.now(ZoneId.of("Asia/Seoul"))
			);
		}
	}
}
