package com.nlbg.store;

import com.nlbg.store.domain.API;
import com.nlbg.store.domain.Item;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StoreApplicationTests {

	@Test
	@DisplayName("Should demonstrate a simple success assertion.")
	void simpleSuccessAssertion() {
		Assertions.assertEquals(1, 1);
	}

	@Test
	@DisplayName("Should demonstrate a simple fail assertion.")
	void simpleFailAssertion() {
		Assertions.assertEquals(1, 2);
	}

	@Test
	@Disabled("Not yet implemented.")
	void simpleDisabledAssertion() {
		Assertions.assertEquals(1, 2);
	}

	@Test
	@DisplayName("Should check all items in the list poorly.")
	void shouldCheckAllItemsInTheListPoorly() {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);

		Assertions.assertEquals(2, numbers.get(0));
		Assertions.assertEquals(3, numbers.get(1));
		Assertions.assertEquals(5, numbers.get(2));
		Assertions.assertEquals(7, numbers.get(3));
	}


	@Test
	@DisplayName("Should check all items in the list greatly.")
	void shouldCheckAllItemsInTheListGreatly() {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);

		//JUNIT
		Assertions.assertAll(() -> Assertions.assertEquals(1, numbers.get(0)),
							 () -> Assertions.assertEquals(3, numbers.get(1)),
		                     () -> Assertions.assertEquals(5, numbers.get(2)),
		                     () -> Assertions.assertEquals(7, numbers.get(3)));
	}

	@Test
	@DisplayName("Should only run the test if some criteria are met.")
	void shouldOnlyRunTheTestIfSomeCriteriaAreMet() {
		API api = new API();
		api.setApiVersion(10);

		Assumptions.assumeTrue(api.getApiVersion() >= 10);
		// these tests should only run on newer versions
		Assertions.assertEquals(1, 1);
	}

	@ParameterizedTest
	@DisplayName("Should create item with same item name.")
	@ValueSource(strings = {"Billiards Cue", "Hello", "World", "Billiards"})
	void shouldCreateItemWithSameName(String expectedItemName) {
		Item item = new Item(expectedItemName);
		Assertions.assertEquals(expectedItemName, item.getItemName());
	}


}
