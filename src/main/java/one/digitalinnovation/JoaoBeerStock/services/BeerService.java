package one.digitalinnovation.JoaoBeerStock.services;


import lombok.AllArgsConstructor;
import one.digitalinnovation.JoaoBeerStock.dto.BeerDTO;
import one.digitalinnovation.JoaoBeerStock.entities.Beer;
import one.digitalinnovation.JoaoBeerStock.enums.BeerType;
import one.digitalinnovation.JoaoBeerStock.exceptions.BeerAlreadyRegisteredException;
import one.digitalinnovation.JoaoBeerStock.exceptions.BeerEmptyStockException;
import one.digitalinnovation.JoaoBeerStock.exceptions.BeerNotFoundException;
import one.digitalinnovation.JoaoBeerStock.exceptions.BeerStockExceededException;
import one.digitalinnovation.JoaoBeerStock.mappers.BeerMapper;
import one.digitalinnovation.JoaoBeerStock.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper = BeerMapper.INSTANCE;

    public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(beerDTO.getName());
        Beer beer = beerMapper.toModel(beerDTO);
        Beer savedBeer = beerRepository.save(beer);
        return beerMapper.toDTO(savedBeer);
    }

    public BeerDTO findByName(String name) throws BeerNotFoundException {
        Beer foundBeer = beerRepository.findByName(name)
                .orElseThrow(() -> new BeerNotFoundException(name));
        return beerMapper.toDTO(foundBeer);
    }

    public List<BeerDTO> listAll() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws BeerNotFoundException {
        verifyIfExists(id);
        beerRepository.deleteById(id);
    }

    public BeerDTO increment(Long id, int quantityToIncrement) throws BeerNotFoundException, BeerStockExceededException {
        Beer beerToIncrementStock = verifyIfExists(id);
        int quantityAfterIncrement = quantityToIncrement + beerToIncrementStock.getQuantity();
        if (quantityAfterIncrement <= beerToIncrementStock.getMax()) {
            beerToIncrementStock.setQuantity(beerToIncrementStock.getQuantity() + quantityToIncrement);
            Beer incrementedBeerStock = beerRepository.save(beerToIncrementStock);
            return beerMapper.toDTO(incrementedBeerStock);
        }
        throw new BeerStockExceededException(id, quantityToIncrement);
    }

    public BeerDTO decrement(Long id, int quantityToDecrement) throws BeerNotFoundException, BeerEmptyStockException {
        Beer beerToIncrementStock = verifyIfExists(id);
        int quantityAfterDecrement = beerToIncrementStock.getQuantity() - quantityToDecrement;
        if (quantityAfterDecrement >= 0) {
            beerToIncrementStock.setQuantity(beerToIncrementStock.getQuantity() - quantityToDecrement);
            Beer incrementedBeerStock = beerRepository.save(beerToIncrementStock);
            return beerMapper.toDTO(incrementedBeerStock);
        }
        throw new BeerEmptyStockException(id, quantityToDecrement);
    }

    public List<BeerDTO> listByType(BeerType type) {
        return beerRepository.findByType(type)
                .stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<BeerDTO> listStockBellow(int limit) {
        return beerRepository.findByQuantityLessThan(limit)
                .stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }

    private void verifyIfIsAlreadyRegistered(String name) throws BeerAlreadyRegisteredException {
        Optional<Beer> optSavedBeer = beerRepository.findByName(name);
        if (optSavedBeer.isPresent()) {
            throw new BeerAlreadyRegisteredException(name);
        }
    }

    private Beer verifyIfExists(Long id) throws BeerNotFoundException {
        return beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }
}