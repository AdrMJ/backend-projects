package com.psychoamj.aj4.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import com.psychoamj.aj4.constants.BookConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "images_url")
public class ImageUrl {

	@Id
	@NotNull(message = BookConstants.NOT_NULL_MESSAGE)
	@Column(name = "image_url_id")
	private Integer imageUrlId;

	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 223, message = BookConstants.IMAGE_URL_LENGTH_MESSAGE)
	@Column(name = "front_url")
	private String frontUrl;
	
	@NotBlank(message = BookConstants.NOT_BLANK_MESSAGE)
	@Length(min = 3, max = 223, message = BookConstants.IMAGE_URL_LENGTH_MESSAGE)
	@Column(name = "back_url")
	private String backUrl;
	
	@Length(min = 3, max = 223, message = BookConstants.IMAGE_URL_LENGTH_MESSAGE)
	@Column(name = "side_url")
	private String sideUrl;
	
	@Length(min = 3, max = 50, message = BookConstants.COLOR_LENGTH_MESSAGE)
	@Column(name = "color")
	private String color;
	
}
