package ee.valiit.back_bank_27.domain.location;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {
    @Mapping(source = "id", target = "locationId")
    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "city.name", target = "cityName")
    AtmLocationDto toDto(Location location);
    AtmLocationInfonInfo toInfo(Location location);

    @Mapping(source ="name", target = "locationName")
    @Mapping(source ="city.id", target = "cityId")
    @Mapping(ignore = true, target = "picture")

    List<AtmLocationDto> toDtos(List<Location> locations);

}