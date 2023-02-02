package ee.valiit.back_bank_27.domain.locationtransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationTransactionRepository extends JpaRepository<LocationTransaction, Integer> {
    @Query("select l from LocationTransaction l where l.location.id = ?1 and l.available = ?2 order by l.transaction.id")
    List<LocationTransaction> findLocationTransactions(Integer locationId, Boolean isAvailable);

    @Query("select l from LocationTransaction l where l.location.id = ?1 order by l.transaction.id")
    List<LocationTransaction> findLocationTransactions(Integer locationId);


}