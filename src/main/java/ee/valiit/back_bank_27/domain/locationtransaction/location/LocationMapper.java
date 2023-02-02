package ee.valiit.back_bank_27.domain.locationtransaction.location;

import ee.valiit.back_bank_27.bank.Status;
import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationResponse;
import ee.valiit.back_bank_27.util.PictureUtil;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {Status.class, PictureUtil.class})
public interface LocationMapper {

    @Mapping(source = "locationName", target = "name")
    @Mapping(constant = Status.ACTIVE, target = "status")
    @Mapping(source = "picture", target = "picture", qualifiedByName = "stringToByteArray")
    Location toEntity(AtmLocationDto atmLocationDto);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String picture) {
        byte[] bytes = picture.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    @Mapping(source = "id",target = "locationId")
    @Mapping(source = "name",target = "locationName")
    @Mapping(source = "city.name",target = "cityName")
    AtmLocationResponse toDto(Location location);

    @Mapping(source = "name",target = "locationName")
    @Mapping(source = "city.id",target = "cityId")
    @Mapping(expression ="java(PictureUtil.byteArrayToString(location.getPicture())",target = "picture")
    AtmLocationDto toInfo(Location location);



    List<AtmLocationResponse> toDtos(List<Location> locations);
}