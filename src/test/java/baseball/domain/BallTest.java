package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("야구 공 테스트")
public class BallTest {

	/**
	 * com vs me
	 * 123    456 : Nothing
	 * 123    231 : 3ball
	 * 123    132 : 1Strike 2ball
	 * 123    123 : 3Strike
	 * ---
	 * 3개     3개 -> 복잡
	 * ---
	 * 1개     1개 -> 간단
	 * ---
	 * 1      3   : Nothing
	 * 1      1   : ????? -> 1S or 1B
	 * (1,1)  (1,1) : 1Strike
	 * (1,1)  (1,2) or (1,3) : 1Ball
	 */
	@DisplayName("야구 공 생성 성공 테스트")
	@Test
	void createBallSuccessTest() {
		Ball comBall = new Ball(1, 1);

		assertThat(comBall).isNotNull();
	}

	@DisplayName("야구 공 생성 테스트")
	@Test
	void nothingTest() {
		Ball comBall = new Ball(1, 1);
		Ball userBall = new Ball(3, 1);

		assertThat(comBall.play(userBall)).isEqualTo(BaseballStatus.NOTHING);
	}

	@DisplayName("야구 볼 테스트")
	@Test
	void ballTest() {
		Ball comBall = new Ball(1, 1);
		Ball userBall = new Ball(1, 2);

		assertThat(comBall.play(userBall)).isEqualTo(BaseballStatus.BALL);
	}

	@DisplayName("야구 볼 테스트")
	@Test
	void strikeTest() {
		Ball comBall = new Ball(1, 1);
		Ball userBall = new Ball(1, 1);

		assertThat(comBall.play(userBall)).isEqualTo(BaseballStatus.STRIKE);
	}
}
