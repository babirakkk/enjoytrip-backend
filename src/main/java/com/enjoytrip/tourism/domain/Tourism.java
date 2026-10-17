package com.enjoytrip.tourism.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tourism")
public class Tourism {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private Long contentId;
	@Column(nullable = false)
	private String title;
	private String addr;
	private Long contentTypeId;
	private String originalImage;
	private String thumbnailImage;
	@Column(precision = 10, scale = 7)
	private BigDecimal longitude;
	@Column(precision = 10, scale = 7)
	private BigDecimal latitude;
	private Long mapLevel;
	private String tel;
	private String zipCode;
	private String lDongRegnCd;
	private String lDongSignguCd;
	private String lclsSystm1;
	private String lclsSystm2;
	private String lclsSystm3;

	public Tourism(
			Long contentId,
			String title,
			String addr,
			Long contentTypeId,
			String originalImage,
			String thumbnailImage,
			BigDecimal longitude,
			BigDecimal latitude,
			Long mapLevel,
			String tel,
			String zipCode,
			String lDongRegnCd,
			String lDongSignguCd,
			String lclsSystm1,
			String lclsSystm2,
			String lclsSystm3
	) {
		this.contentId = contentId;
		this.title = title;
		this.addr = addr;
		this.contentTypeId = contentTypeId;
		this.originalImage = originalImage;
		this.thumbnailImage = thumbnailImage;
		this.longitude = longitude;
		this.latitude = latitude;
		this.mapLevel = mapLevel;
		this.tel = tel;
		this.zipCode = zipCode;
		this.lDongRegnCd = lDongRegnCd;
		this.lDongSignguCd = lDongSignguCd;
		this.lclsSystm1 = lclsSystm1;
		this.lclsSystm2 = lclsSystm2;
		this.lclsSystm3 = lclsSystm3;
	}
}
