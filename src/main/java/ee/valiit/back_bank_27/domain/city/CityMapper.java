package ee.valiit.back_bank_27.domain.city;

import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {

    @Mapping(source = "id", target = "cityId")
    @Mapping(source = "name", target = "cityName")
    CityDto toDto(City city);

    List<CityDto> toDtos(List<City> city);

}