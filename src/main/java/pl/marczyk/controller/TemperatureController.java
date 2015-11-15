package pl.marczyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marczyk.model.Temperature;
import pl.marczyk.service.ChartData;
import pl.marczyk.service.DataService;
import pl.marczyk.service.Dataset;

/**
 * Created by marcin on 14.11.15.
 */
@RestController()
@RequestMapping("/api")
public class TemperatureController {

    @Autowired
    private DataService dataService;

    @RequestMapping("/latest10")
    public ChartData getLatest10() {
        return dataService.getLatestDataWithLabels();
    }

    @RequestMapping("/latest")
    public Temperature getLatest() {
        return dataService.getLatestOne();
    }
}
