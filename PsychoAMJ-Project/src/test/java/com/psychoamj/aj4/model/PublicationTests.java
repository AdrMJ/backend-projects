package com.psychoamj.aj4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import com.psychoamj.aj4.constants.BookConstants;
import com.psychoamj.aj4.models.Publication;

public class PublicationTests {
	private Validator validator;
	private Publication emptyPublication;
	private static ValidatorFactory factory;
	
	@BeforeEach
	public void setUp() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		emptyPublication = new Publication();
	}
	
	// publicationId test methods
	
	@Test
	public void shouldSetAndRetrievePublicaitonIdMatches() {
		Integer publicationId = 1;
		emptyPublication.setPublicationId(publicationId);
		
		assertEquals(publicationId, emptyPublication.getPublicationId());
	}
	@Test
	public void shouldFailWhenPublicationIdIsNull() {
		emptyPublication.setPublicationId(null);
		
		assertFieldValidationMessage(emptyPublication, BookConstants.NOT_NULL_MESSAGE);
	}
	
	// publisher test methods
	
	@Test
	public void shouldSetAndRetrievePublisherMatches() {
		String publisher = "A".repeat(10);
		emptyPublication.setPublisher(publisher);
		
		assertEquals(publisher, emptyPublication.getPublisher());
	}
	
	@Test
	public void shouldFailWhenPublisherIsBlank() {
		emptyPublication.setPublisher("");
		
		assertFieldValidationMessage(emptyPublication, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenPublisherIsTooShort() {
		emptyPublication.setPublisher("A");
		
		assertFieldValidationMessage(emptyPublication, BookConstants.PUBLISHER_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenPublisherIsTooLong() {
		emptyPublication.setPublisher("A".repeat(1001));
		
		assertFieldValidationMessage(emptyPublication, BookConstants.PUBLISHER_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenPublisherIsNull() {
		emptyPublication.setPublisher(null);
		
		assertFieldValidationMessage(emptyPublication, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	// language tests methods
	
	@Test
	public void shouldSetAndRetrieveLanguageMatches() {
		String language = "language";
		emptyPublication.setLanguage(language);
		
		assertEquals(language, emptyPublication.getLanguage());
	}
	
	@Test
	public void shouldFailWhenLanguageIsBlank() {
		emptyPublication.setLanguage("");
		
		assertFieldValidationMessage(emptyPublication, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenLanguageIsTooShort() {
		emptyPublication.setLanguage("A");
		
		assertFieldValidationMessage(emptyPublication, BookConstants.LANGUAGE_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenLanguageIsTooLong() {
		emptyPublication.setLanguage("A".repeat(60));
		
		assertFieldValidationMessage(emptyPublication, BookConstants.LANGUAGE_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenLanguageIsNull() {
		emptyPublication.setLanguage(null);
		
		assertFieldValidationMessage(emptyPublication, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	//releaseDate test methods
	
	@Test
	public void shouldSetAndRetrieveReleaseDateMatches() {
		LocalDate releaseDate = LocalDate.of(2020, 10, 1);
		emptyPublication.setReleaseDate(releaseDate);
		
		assertEquals(releaseDate, emptyPublication.getReleaseDate());
	}
	@Test
	public void shouldFailWhenReleaseDateIsNull() {
		emptyPublication.setReleaseDate(null);
		
		assertFieldValidationMessage(emptyPublication, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenReleaseDateIsTooOld() {
		emptyPublication.setReleaseDate(LocalDate.of(2000, 1, 1));
		
		assertFieldValidationMessage(emptyPublication, BookConstants.CORRECT_DATE_MESSAGE);
	}

	@Test
	public void shouldFailWhenReleaseDateIsInFuture() {
		emptyPublication.setReleaseDate(LocalDate.of(3000, 1, 1));
		
		assertFieldValidationMessage(emptyPublication, BookConstants.CORRECT_DATE_MESSAGE);
	}
	
	// publisherUrl test methods
	
	@Test
	public void shouldSetAndRetrievePublisherUrlMatches() {
		String publisherUrl = "publisherUrl";
		emptyPublication.setPublisherUrl(publisherUrl);
		
		assertEquals(publisherUrl, emptyPublication.getPublisherUrl());
	}
	
	@Test
	public void shouldFailWhenPublisherUrlIsBlank() {
		emptyPublication.setPublisherUrl("");
		
		assertFieldValidationMessage(emptyPublication, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	@Test
	public void shouldFailWhenPublisherUrlIsTooShort() {
		emptyPublication.setPublisherUrl("A");
		
		assertFieldValidationMessage(emptyPublication, BookConstants.PUBLISHER_URL_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenPublisherUrlIsTooLong() {
		emptyPublication.setPublisherUrl("A".repeat(60));
		
		assertFieldValidationMessage(emptyPublication, BookConstants.PUBLISHER_URL_LENGTH_MESSAGE);
	}

	@Test
	public void shouldFailWhenPublisherUrlIsNull() {
		emptyPublication.setPublisherUrl(null);
		
		assertFieldValidationMessage(emptyPublication, BookConstants.NOT_BLANK_MESSAGE);
	}
	
	
	//Other methods:
	
		private void assertFieldValidationMessage(Publication publication, String expectedMessage) {
			try {
				validator.validate(publication);	
			} catch (ConstraintViolationException exception) {
				ConstraintViolation<?> violation = exception.getConstraintViolations().iterator().next();
				assertEquals(expectedMessage, violation.getMessage());
			}	
		}
}
