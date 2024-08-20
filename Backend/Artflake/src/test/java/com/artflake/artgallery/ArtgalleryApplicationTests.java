package com.artflake.artgallery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArtgalleryApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertDoesNotThrow(this::donotThrowException);
	}

	private void donotThrowException() {
		//Now will never throw exception.
	}

}
