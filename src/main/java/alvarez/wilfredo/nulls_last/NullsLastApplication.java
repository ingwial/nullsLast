package alvarez.wilfredo.nulls_last;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@SpringBootApplication
public class NullsLastApplication {

	public static void main(String[] args) {
		SpringApplication.run(NullsLastApplication.class, args);
		Logger logger = LoggerFactory.getLogger(NullsLastApplication.class);

		List<Integer> integers = Arrays.asList(null, 9, 11, 7, 5, null);

		//NullPointerException
		/*OptionalInt max = integers.stream().mapToInt(Integer::valueOf).max();
		logger.info("Max: {}", max);*/

		//NullPointerException
		/*Optional<Integer> maxi = integers.stream().max(Comparator.nullsLast(Comparator.naturalOrder()));
		logger.info("Maxi: {}", maxi);*/

		Optional<Integer> max = integers.stream().max(Comparator.nullsFirst(Comparator.naturalOrder()));
		max.ifPresent(m -> logger.info("Max: {}", m));

		Integer maximum = Collections.max(integers, Comparator.nullsLast(Comparator.naturalOrder()));
		logger.info("Maximum: {}", maximum);

		List<Integer> sortedArray = integers.stream().sorted(Comparator.nullsLast(Comparator.naturalOrder())).toList();
		logger.info("Sorted array: {}", sortedArray);
	}

}
