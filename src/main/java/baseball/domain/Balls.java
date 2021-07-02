package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	private final List<Ball> balls = new ArrayList<>();

	public Balls(List<Integer> ballList) {

		for (int i = 0; i < ballList.size(); i++) {
			this.balls.add(new Ball(ballList.get(i), i + 1));
		}
	}

	public BaseballStatus play(Ball userBall) {
		return this.balls.stream()
				.map(comBall -> comBall.play(userBall))
				.filter(status -> status.isNotNothing())
				.findFirst()
				.orElse(BaseballStatus.NOTHING);
	}

	public BaseballResult playBaseball(Balls userBalls) {

		BaseballResult result = new BaseballResult();
		for (Ball ball : userBalls.getBall()) {
			result.calculate(this.play(ball));
		}

		return result;
	}

	private List<Ball> getBall() {
		return this.balls;
	}
}
