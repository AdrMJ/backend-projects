package com.psychoamj.aj4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.psychoamj.aj4.constants.BookConstants;
import com.psychoamj.aj4.models.ImageUrl;

public class ImageUrlTests {

	private Validator validator;
	private ImageUrl emptyImageUrl;
	private static ValidatorFactory factory;

	@BeforeEach
	public void setUp() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		emptyImageUrl = new ImageUrl();
	}

	// imageUrlId test methods

	@Test
	public void shouldSetAndRetrieveImageUrlIdMatches() {
		Integer imageUrlId = 1;
		emptyImageUrl.setImageUrlId(imageUrlId);

		assertEquals(imageUrlId, emptyImageUrl.getImageUrlId());
	}

	@Test
	public void shouldFailWhenImageUrlIdIsNull() {
		emptyImageUrl.setImageUrlId(null);

		assertFieldValidationMessage(emptyImageUrl, BookConstants.NOT_NULL_MESSAGE);
	}

	// frontUrl test methods

	@Test
	public void shouldSetAndRetrieveFrontUrlMatches() {
		String frontUrl = "imageUrl";
		emptyImageUrl.setFrontUrl(frontUrl);
		;

		assertEquals(frontUrl, emptyImageUrl.getFrontUrl());
	}

	@Test
	public void shouldFailWhenFrontUrlIsNull() {
		emptyImageUrl.setFrontUrl(null);

		assertFieldValidationMessage(emptyImageUrl, BookConstants.NOT_BLANK_MESSAGE);
	}

	@Test
	public void shouldFailWhenFrontUrlIsBlank() {
		emptyImageUrl.setFrontUrl("");

		assertFieldValidationMessage(emptyImageUrl, BookConstants.NOT_BLANK_MESSAGE);
	}

	@Test
	public void shouldFailWhenFrontUrlIsTooShort() {
		emptyImageUrl.setFrontUrl("A");

		assertFieldValidationMessage(emptyImageUrl, BookConstants.IMAGE_URL_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenFrontUrlIsTooLong() {
		emptyImageUrl.setFrontUrl("A".repeat(2001));

		assertFieldValidationMessage(emptyImageUrl, BookConstants.IMAGE_URL_LENGTH_MESSAGE);
	}
	// sideUrl test methods

	@Test
	public void shouldSetAndRetrieveSideUrlMatches() {
		String sideUrl = "imageUrl";
		emptyImageUrl.setSideUrl(sideUrl);
		

		assertEquals(sideUrl, emptyImageUrl.getSideUrl());
	}

	@Test
	public void shouldFailWhenSideUrlIsNull() {
		emptyImageUrl.setSideUrl(null);

		assertFieldValidationMessage(emptyImageUrl, BookConstants.NOT_BLANK_MESSAGE);
	}

	@Test
	public void shouldFailWhenSideUrlIsBlank() {
		emptyImageUrl.setSideUrl("");

		assertFieldValidationMessage(emptyImageUrl, BookConstants.NOT_BLANK_MESSAGE);
	}

	@Test
	public void shouldFailWhenSideUrlIsTooShort() {
		emptyImageUrl.setSideUrl("A");

		assertFieldValidationMessage(emptyImageUrl, BookConstants.IMAGE_URL_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenSideUrlIsTooLong() {
		emptyImageUrl.setSideUrl("A".repeat(2001));

		assertFieldValidationMessage(emptyImageUrl, BookConstants.IMAGE_URL_LENGTH_MESSAGE);
	}

	//backUrl test methods

		@Test
		public void shouldSetAndRetrieveBackUrlMatches() {
			String backUrl = "imageUrl";
			emptyImageUrl.setBackUrl(backUrl);;		
			
			assertEquals(backUrl, emptyImageUrl.getBackUrl());
		}
		
		@Test
		public void shouldFailWhenBackUrlIsNull() {
			emptyImageUrl.setBackUrl(null);

			assertFieldValidationMessage(emptyImageUrl, BookConstants.NOT_BLANK_MESSAGE);
		}
		
		@Test
		public void shouldFailWhenBackUrlIsBlank() {
			emptyImageUrl.setBackUrl("");
			
			assertFieldValidationMessage(emptyImageUrl, BookConstants.NOT_BLANK_MESSAGE);
		}
		
		@Test
		public void shouldFailWhenBackUrlIsTooShort() {
			emptyImageUrl.setBackUrl("A");
			
			assertFieldValidationMessage(emptyImageUrl, BookConstants.IMAGE_URL_LENGTH_MESSAGE);
		}

		@Test
		public void shouldFailWhenBackUrlIsTooLong() {
			emptyImageUrl.setBackUrl("A".repeat(2001));
			
			assertFieldValidationMessage(emptyImageUrl, BookConstants.IMAGE_URL_LENGTH_MESSAGE);
		}
		//color test methods
		
		@Test
		public void shouldSetAndRetrieveColorMatches() {
			String color = "color";
			emptyImageUrl.setColor(color);;		
			
			assertEquals(color, emptyImageUrl.getColor());
		}
		
		@Test
		public void shouldFailWhenColorIsNull() {
			emptyImageUrl.setColor(null);

			assertFieldValidationMessage(emptyImageUrl, BookConstants.NOT_BLANK_MESSAGE);
		}
		
		@Test
		public void shouldFailWhenColorIsBlank() {
			emptyImageUrl.setColor("");
			
			assertFieldValidationMessage(emptyImageUrl, BookConstants.NOT_BLANK_MESSAGE);
		}
		
		@Test
		public void shouldFailWhenColorIsTooShort() {
			emptyImageUrl.setColor("A");
			
			assertFieldValidationMessage(emptyImageUrl, BookConstants.IMAGE_URL_LENGTH_MESSAGE);
		}

		@Test
		public void shouldFailWhenColorIsTooLong() {
			emptyImageUrl.setColor("A".repeat(2001));
			
			assertFieldValidationMessage(emptyImageUrl, BookConstants.IMAGE_URL_LENGTH_MESSAGE);
		}
	
	// Other methods
	private void assertFieldValidationMessage(ImageUrl imageUrl, String expectedMessage) {
		try {
			validator.validate(emptyImageUrl);
		} catch (ConstraintViolationException exception) {
			ConstraintViolation<?> violation = exception.getConstraintViolations().iterator().next();
			assertEquals(expectedMessage, violation.getMessage());
		}

	}
}
