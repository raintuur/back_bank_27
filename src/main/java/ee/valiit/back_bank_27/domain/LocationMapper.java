package ee.valiit.back_bank_27.domain;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {


    @Mapping(source = "id",target = "locationId")
    @Mapping(source = "name",target = "locationName")
    @Mapping(source = "city.name",target = "cityName")
    AtmLocationDto toDto(Location location);

}