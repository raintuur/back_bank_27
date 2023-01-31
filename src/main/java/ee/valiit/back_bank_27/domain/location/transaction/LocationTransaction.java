package ee.valiit.back_bank_27.domain.location.transaction;

import ee.valiit.back_bank_27.domain.location.AtmLocationDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "location_transaction")
public class LocationTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private AtmLocationDto location;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transactions_id", nullable = false)
    private Transaction transactions;

    @NotNull
    @Column(name = "available", nullable = false)
    private Boolean available = false;

}