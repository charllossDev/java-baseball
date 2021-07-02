package baseball.domain;

public enum BaseballStatus {
	STRIKE, BALL, NOTHING;

	public boolean isNothing() {
		return this.equals(NOTHING);
	}

	public boolean isNotNothing() {
		return !this.isNothing();
	}
}
