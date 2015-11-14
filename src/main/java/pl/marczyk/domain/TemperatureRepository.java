package pl.marczyk.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.marczyk.model.Temperature;

import java.util.List;

/**
 * Created by marcin on 14.11.15.
 */
@Repository
public interface TemperatureRepository extends CrudRepository<Temperature, Long> {
    List<Temperature> findFirst10ByOrderByTimestampDesc();
    Temperature findFirstByOrderByTimestampDesc();
}
