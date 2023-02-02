package ee.valiit.back_bank_27.domain.locationtransaction.transaction;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Resource
    private TransactionRepository transactionRepository;

    public void findAllTransactions() {
        List<Transaction> = transactions transactionRepository.findAll();
        return transactions;

    }

}
