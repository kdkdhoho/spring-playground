package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringPlayGroundApplicationTests {

	@Test
	void contextLoads() {
		assertThat(new TestApplication()).isNotNull();
	}
}
