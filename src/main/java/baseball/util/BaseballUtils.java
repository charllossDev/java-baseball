package baseball.util;

public class BaseballUtils {


	public static final int BASE_BALL_MIN_VALUE = 1;
	public static final int BASE_BALL_MAX_VALUE = 9;

	public static boolean isBall(String inputStr) {
		if (!isNumber(inputStr)) {
			return false;
		}
		return isBall(Integer.parseInt(inputStr));
	}

	public static boolean isBall(int input) {
		return input >= BASE_BALL_MIN_VALUE && input <= BASE_BALL_MAX_VALUE;
	}

	static boolean isNumber(String input) {
		if (input != null && input.trim().isEmpty()) {
			return false;
		}

		try {
			Integer.parseInt(input);
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
		return true;
	}
}
