package pl.marczyk.scheduler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.marczyk.DS18B20.DS18B20Parser;
import pl.marczyk.domain.TemperatureRepository;
import pl.marczyk.model.Temperature;

import java.util.Date;

/**
 * Created by marcin on 14.11.15.
 */
@Component
public class TemperatureReaderScheduler {
    private final Logger LOG = LogManager.getRootLogger();

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private DS18B20Parser parser;

    @Scheduled(fixedRate = 1000)
    public void readTemperature(){
        parser.init("28-0000053bca4a");
        Double temp = null;
        try {
            temp = parser.getTemperature();
            Temperature temperature = new Temperature(new Date(), temp);
            LOG.debug("Temperature read: " + temperature.getValue());
            temperatureRepository.save(temperature);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

    }
}
