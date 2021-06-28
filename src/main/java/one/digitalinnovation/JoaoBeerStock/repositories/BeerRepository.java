package one.digitalinnovation.JoaoBeerStock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import one.digitalinnovation.JoaoBeerStock.entities.Beer;
import one.digitalinnovation.JoaoBeerStock.enums.BeerType;

import java.util.List;
import java.util.Optional;

public interface BeerRepository extends JpaRepository<Beer, Long> {

    Optional<Beer> findByName(String name);

    List<Beer> findByType(BeerType type);

    List<Beer> findByQuantityLessThan(int limit);
}