package ee.valiit.back_bank_27.domain.locationtransaction.transaction;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Resource
    private TransactionRepository transactionRepository;


    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction findTransaction(Integer typeId) {
        return transactionRepository.findById(typeId).get();
    }
}
