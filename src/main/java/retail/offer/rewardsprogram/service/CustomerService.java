package retail.offer.rewardsprogram.service;

import java.util.List;

import retail.offer.rewardsprogram.model.CustomerDTO;
import retail.offer.rewardsprogram.model.TransactionRecordDTO;

public interface CustomerService {

	CustomerDTO findById(Long custId);

	List<TransactionRecordDTO> findThreeMonthTrans();

}