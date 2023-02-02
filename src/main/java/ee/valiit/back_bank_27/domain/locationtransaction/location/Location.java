package ee.valiit.back_bank_27.domain.locationtransaction.location;

import ee.valiit.back_bank_27.domain.city.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "number_of_atms", nullable = false)
    private Integer numberOfAtms;

    @Column(name = "picture")
    private byte[] picture;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @Column(name = "longitude", precision = 8, scale = 6)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 8, scale = 6)
    private BigDecimal latitude;

}