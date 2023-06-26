package retail.offer.rewardsprogram.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import retail.offer.rewardsprogram.entity.Customer;
import retail.offer.rewardsprogram.util.DataBuilder;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerRepositoryTest {

	private DataBuilder testData = new DataBuilder();

	@Autowired
	private CustomerRepository testRepo;

	@Test
	void test_save_find() {
		testRepo.save(testData.createCustomer("Praveen"));
		testRepo.save(testData.createCustomer("Arun"));

		List<Customer> customers = testRepo.findAll();
		assertEquals(2, customers.size());

	}

}