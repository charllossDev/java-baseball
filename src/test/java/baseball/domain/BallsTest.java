package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Balls 야구게임 생성 테스트")
public class BallsTest {

	/**
	 * com vs me
	 * 123    456 : Nothing
	 * 123    231 : 3ball
	 * 123    132 : 1Strike 2ball
	 * 123    123 : 3Strike
	 * ---
	 * 3개     3개 -> 복잡
	 * ---
	 * 123    456 : Nothing
	 * value, position
	 * (1,1), (2,2), (3,3) : (4,1), (5,2), (6,3) -> Nothing
	 * (1,1), (2,2), (3,3) : (1,1) -> 1S
	 * (1,1), (2,2), (3,3) : (2,1) -> 1B
	 * (1,1), (2,2), (3,3) : (4,1) -> Nothing
	 * ---
	 * 1개     1개 -> 간단
	 * ---
	 * 1      3   : Nothing
	 * 1      1   : ????? -> 1S or 1B
	 * (1,1)  (1,1) : 1Strike
	 * (1,1)  (1,2) or (1,3) : 1Ball
	 * ---
	 */

	@DisplayName("야구 Balls 생성 테스트")
	@Test
	void createBallsTest() {
		Balls comBalls = new Balls(Arrays.asList(6,7,8));
		Ball userBall = new Ball(1,9);
		assertThat(comBalls.play(userBall)).isEqualTo(BaseballStatus.NOTHING);
	}

	@DisplayName("야구 Balls BALL 테스트")
	@Test
	void ballBallsTest() {
		Balls comBalls = new Balls(Arrays.asList(6,7,8));
		Ball userBall = new Ball(6,2);
		assertThat(comBalls.play(userBall)).isEqualTo(BaseballStatus.BALL);
	}

	@DisplayName("야구 Balls STRIKE 테스트")
	@Test
	void strikeBallsTest() {
		Balls comBalls = new Balls(Arrays.asList(6,7,8));
		Ball userBall = new Ball(6,1);
		assertThat(comBalls.play(userBall)).isEqualTo(BaseballStatus.STRIKE);
	}

	@DisplayName("Balls vs Balls 테스트")
	@Test
	void userBallsComBallsTest() {
		Balls comBalls = new Balls(Arrays.asList(1,2,3));
		Balls userBalls = new Balls(Arrays.asList(4,5,6));

		BaseballResult result = comBalls.playBaseball(userBalls);
		assertThat(result.isNothing()).isTrue();
	}

	@DisplayName("3Strike")
	@Test
	void gameEndTest() {
		Balls comBalls = new Balls(Arrays.asList(1,2,3));
		Balls userBalls = new Balls(Arrays.asList(1,2,3));

		assertThat(comBalls.playBaseball(userBalls).getStrike()).isEqualTo(3);
	}
}
