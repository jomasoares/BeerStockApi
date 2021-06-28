package one.digitalinnovation.JoaoBeerStock.mappers;

import one.digitalinnovation.JoaoBeerStock.dto.BeerDTO;
import one.digitalinnovation.JoaoBeerStock.entities.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    Beer toModel(BeerDTO beerDTO);

    BeerDTO toDTO(Beer beer);
}