package retail.offer.rewardsprogram.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import retail.offer.rewardsprogram.entity.Customer;
import retail.offer.rewardsprogram.entity.TransactionRecord;
import retail.offer.rewardsprogram.model.CustomerDTO;
import retail.offer.rewardsprogram.model.TransactionRecordDTO;
import retail.offer.rewardsprogram.repo.CustomerRepository;
import retail.offer.rewardsprogram.repo.TransactionRecordRepository;
import retail.offer.rewardsprogram.service.CustomerService;
import retail.offer.rewardsprogram.service.DataTransformer;
import retail.offer.rewardsprogram.util.DataBuilder;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private DataTransformer dataTransformer;

	private DataBuilder testData = new DataBuilder();

	@Autowired
	private TransactionRecordRepository tranRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see retail.offer.rewardsprogram.service.CustomerService#findById(java.lang.Long)
	 */
	@Override
	public CustomerDTO findById(Long custId) {
		Optional<Customer> foundCust = custRepo.findById(custId);
		if (foundCust.isPresent()) {
			return dataTransformer.toCustomerModel(foundCust.get());
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see retail.offer.rewardsprogram.service.CustomerService#findThreeMonthTrans()
	 */
	@Override
	public List<TransactionRecordDTO> findThreeMonthTrans() {
		List<TransactionRecordDTO> threeMonthTrans = new ArrayList<>();
		setup();
		List<TransactionRecord> threeMonthTranRecords = tranRepo
				.findAllInLastThreeMonth();

		threeMonthTranRecords.forEach(source -> {
			TransactionRecordDTO target = new TransactionRecordDTO();
			BeanUtils.copyProperties(source, target);
			target.setCustomer(dataTransformer.toCustomerModel(source.getCustomer()));
			threeMonthTrans.add(target);
		});

		return threeMonthTrans;
	}

	private void setup() {
		if (custRepo.findAll().isEmpty()) {
			Customer praveen = custRepo.save(testData.createCustomer("Praveen"));
			Customer arun = custRepo.save(testData.createCustomer("Arun"));

			tranRepo.save(testData.createTransactionRecord(praveen, "50", 0, 4));
			tranRepo.save(testData.createTransactionRecord(praveen, "10", 0, 2));
			tranRepo.save(testData.createTransactionRecord(praveen, "30", 1, 2));
			tranRepo.save(testData.createTransactionRecord(praveen, "300", 1, 5));
			tranRepo.save(testData.createTransactionRecord(praveen, "40", 2, 0));
			tranRepo.save(testData.createTransactionRecord(praveen, "100", 2, 4));
			tranRepo.save(testData.createTransactionRecord(praveen, "1000", 2, 4));

			tranRepo.save(testData.createTransactionRecord(arun, "181", 1, 3));
			tranRepo.save(testData.createTransactionRecord(arun, "286", 2, 1));
			tranRepo.save(testData.createTransactionRecord(arun, "50", 1, 15));
			tranRepo.save(testData.createTransactionRecord(arun, "40", 2, 14));
			tranRepo.save(testData.createTransactionRecord(arun, "30", 0, 15));
			tranRepo.save(testData.createTransactionRecord(arun, "517", 0, 14));
			tranRepo.save(testData.createTransactionRecord(arun, "225", 0, 14));
		}
	}

}