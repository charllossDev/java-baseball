package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("야구 유틸 관련 테스트")
class BaseballUtilsTest {

	@DisplayName("숫자 확인 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3:true", "66777:true","\t\t:false", "   :false", " :false", "inputString:false"}, delimiter = ':')
	void isNumberTest(String inputStr, boolean expectedResult) {
		assertThat(BaseballUtils.isNumber(inputStr)).isEqualTo(expectedResult);
	}

	@DisplayName("야구 공 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0:false", "1:true", "9:true", "10:false", "temp:false"}, delimiter = ':')
	void isBaseBallTest(String inputStr, boolean expectedResult) {
		assertThat(BaseballUtils.isBall(inputStr)).isEqualTo(expectedResult);
	}
}