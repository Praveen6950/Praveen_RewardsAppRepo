package retail.offer.rewardsprogram.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import retail.offer.rewardsprogram.util.DataBuilder;

public class MonthlyRewardsTest {
	private DataBuilder dataBuilder = new DataBuilder();

	private CustomerDTO praveen = dataBuilder.createCustomerDTO("Praveen");

	private MonthlyRewards testClass = new MonthlyRewards(praveen);

	@Test
	void test_getMonthlyTotalRewardPoint() {

		List<TransactionRecordDTO> trans = new ArrayList<>();
		trans.add(dataBuilder.createTransactionRecordDTO(praveen, "50", 2, 1));
		trans.add(dataBuilder.createTransactionRecordDTO(praveen, "120", 2, 1));
		testClass.getMonthlyTrans().put(Month.JUNE, trans);

		assertEquals(0, testClass.getMonthlyTotalRewardPoint().get(Month.JUNE).compareTo(new BigDecimal("90")));

	}

}