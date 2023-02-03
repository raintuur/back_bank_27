package ee.valiit.back_bank_27.domain.locationtransaction;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void saveLocationTransactions(List<LocationTransaction> locationTransactions) {
        locationTransactionRepository.saveAll(locationTransactions);
    }

    public LocationTransaction findLocation(Integer locationId, Integer transactionId);

}
