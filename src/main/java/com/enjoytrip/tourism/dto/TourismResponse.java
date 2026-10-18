package com.enjoytrip.tourism.dto;

import java.math.BigDecimal;

import com.enjoytrip.tourism.domain.Tourism;

import io.swagger.v3.oas.annotations.media.Schema;

public record TourismResponse (
		@Schema(description = "콘텐츠 ID") Long contentId,
		@Schema(description = "제목") String title,
		@Schema(description = "주소") String addr,
		@Schema(description = "관광타입 ID") Long contentTypeId,
		@Schema(description = "대표 이미지 (원본)") String originalImage,
		@Schema(description = "대표 이미지 (썸네일)") String thumbnailImage,
		@Schema(description = "GPS X좌표 (경도)") BigDecimal longitude,
		@Schema(description = "GPS Y좌표 (위도)") BigDecimal latitude,
		@Schema(description = "지도 확대 수준") Long mapLevel,
		@Schema(description = "전화번호") String tel,
		@Schema(description = "우편번호") String zipCode,
		@Schema(description = "법정동 시도 코드") String lDongRegnCd,
		@Schema(description = "법정동 시군구 코드") String lDongSignguCd,
		@Schema(description = "분류체계 대분류") String lclsSystm1,
		@Schema(description = "분류체계 중분류") String lclsSystm2,
		@Schema(description = "분류체계 소분류") String lclsSystm3
) {
	public static TourismResponse from(Tourism tourism) {
		return new TourismResponse(
				tourism.getContentId(),
				tourism.getTitle(),
				tourism.getAddr(),
				tourism.getContentTypeId(),
				tourism.getOriginalImage(),
				tourism.getThumbnailImage(),
				tourism.getLongitude(),
				tourism.getLatitude(),
				tourism.getMapLevel(),
				tourism.getTel(),
				tourism.getZipCode(),
				tourism.getLDongRegnCd(),
				tourism.getLDongSignguCd(),
				tourism.getLclsSystm1(),
				tourism.getLclsSystm2(),
				tourism.getLclsSystm3()
		);
	}
}
