package ee.valiit.back_bank_27.domain.locationtransaction.location;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    @Mapping(source = "locationName", target = "name")
    @Mapping(source = "numberOfAtms", target = "numberOfAtms")
    @Mapping(constant = "A", target = "status")
    @Mapping(source = "picture", target = "picture", qualifiedByName = "stringToByteArray")
    Location toEntity(AtmLocationInfo atmLocationInfo);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String picture) {
        byte[] bytes = picture.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }


    @Mapping(source = "id", target = "locationId")
    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "city.name", target = "cityName")
    AtmLocationDto toDto(Location location);


    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(ignore = true, target = "picture")
    AtmLocationInfo toInfo(Location location);


    List<AtmLocationDto> toDtos(List<Location> locations);

}