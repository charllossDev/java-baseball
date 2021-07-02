package baseball.domain;

public class BaseballResult {

	private int strike;
	private int ball;

	public void calculate(BaseballStatus baseballStatus) {
		if (BaseballStatus.STRIKE.equals(baseballStatus)) {
			this.strike++;
		}

		if (BaseballStatus.BALL.equals(baseballStatus)) {
			this.ball++;
		}
	}

	public boolean isNothing() {
		return (this.strike + this.ball) == 0;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
