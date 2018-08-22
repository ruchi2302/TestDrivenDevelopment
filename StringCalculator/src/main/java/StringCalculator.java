import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StringCalculator {
	
	Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public int addMoreNumber(String input) {
		Integer sum = 0;
		String delimiter = null;
		if (input.length() != 0) {
			if (input.startsWith("//")) {
				delimiter = input.substring(2, 3);
				input = input.substring(input.indexOf("\n") + 1);

			}
			List<String> listStringNumbers = Arrays.asList(input.split("\n|,|" + delimiter));
			sum = (Integer) listStringNumbers.stream().map(n -> Integer.parseInt(n)).filter(n -> n <= 1000)
					.collect(Collectors.reducing((n1, n2) -> n1 + n2)).get();
		}
		logger.info(""+sum);
		return sum;
		 
	}
}
 