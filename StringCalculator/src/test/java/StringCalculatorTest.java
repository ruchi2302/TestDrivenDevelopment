import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;
@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {
	@InjectMocks
	StringCalculator stringCalculator = new StringCalculator();

	@Mock
	Logger logger;

	@Test
	public void shouldReturnZeroWhenInputIsEmpty() {
		int actualResult = stringCalculator.addMoreNumber("");
		Assert.assertEquals(0, actualResult);

	}
 
	@Test
	public void shouldRetrunSameNumberWhenInputIsSingle() {
		int actualResult = stringCalculator.addMoreNumber("1");
		Assert.assertEquals(1, actualResult);
	}

	@Test
	public void shouldReturnSumWhenInputIsTwoNumbers() {
		int actualResult = stringCalculator.addMoreNumber("1,2");
		Assert.assertEquals(3, actualResult);
	}

	@Test
	public void shouldReturnSumWhenInputIsMoreThanTwoNumbers() {
		int actualResult = stringCalculator.addMoreNumber("1,2,5");
		Assert.assertEquals(8, actualResult);
	}

	@Test
	public void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
		Assert.assertEquals(1 + 2 + 10, stringCalculator.addMoreNumber("1,2\n10"));
	}

	@Test
	public void whenDelimiterIsSupportedThenSeperateNumbers() {
		Assert.assertEquals(1 + 2 + 10, stringCalculator.addMoreNumber("//;\n1;2;10"));

	}

	@Test
	public void whenNumbersIsGreaterThanThousand() {
		Assert.assertEquals(2 + 10, stringCalculator.addMoreNumber("2,1001,10"));

	}

	@Test
	public void shouldAddLogger() {
		stringCalculator.addMoreNumber("//;\n1;2;10");
		Mockito.verify(logger).info("13");

	}
}
