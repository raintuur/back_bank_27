package ee.valiit.back_bank_27.domain.location;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.LocationDto;
import jdk.dynalink.linker.LinkerServices;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {


    @Mapping(source = "id",target = "locationId")
    @Mapping(source = "name",target = "locationName")
    @Mapping(source = "city.name",target = "cityName")
    AtmLocationDto toDto(Location location);


    List<AtmLocationDto> toDtos(List<Location> locations);


}