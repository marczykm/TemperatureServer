package pl.marczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marczyk.domain.TemperatureRepository;
import pl.marczyk.model.Temperature;

import java.util.List;

/**
 * Created by marcin on 14.11.15.
 */
@RestController()
@RequestMapping("/api")
public class TemperatureController {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @RequestMapping("/all")
    public Iterable<Temperature> getAll(){
        return temperatureRepository.findAll();
    }

    @RequestMapping("/latest10")
    public List<Temperature> getLatest10() {
        return temperatureRepository.findFirst10ByOrderByTimestampDesc();
    }

    @RequestMapping("/latest")
    public Temperature getLatest() {
        return temperatureRepository.findFirstByOrderByTimestampDesc();
    }
}
