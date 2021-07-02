package baseball.domain;

import java.util.Objects;

public class Ball {

	private final int value;
	private final int position;

	public Ball(int value, int position) {
		this.value = value;
		this.position = position;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ball ball = (Ball) o;
		return value == ball.value && position == ball.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, position);
	}

	public BaseballStatus play(Ball userBall) {

		if (this.equals(userBall)) {
			return BaseballStatus.STRIKE;
		}

		if (this.isMatchBall(userBall)) {
			return BaseballStatus.BALL;
		}

		return BaseballStatus.NOTHING;
	}

	private boolean isMatchBall(Ball userBall) {
		return this.getValue() == userBall.getValue();
	}
}
