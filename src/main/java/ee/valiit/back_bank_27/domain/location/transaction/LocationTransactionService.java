package ee.valiit.back_bank_27.domain.location.transaction;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationTransactionService {

    @Resource
    private LocationTransactionRepository locationTransactionRepository;


    public List<LocationTransaction> findLocationTransactions(Integer locationId, Boolean isAvailable) {
        return locationTransactionRepository.findLocationTransactions(locationId, isAvailable);
    }

    public List<LocationTransaction> findLocationTransactions(Integer locationId) {
        return locationTransactionRepository.findLocationTransactions(locationId);
}

}
