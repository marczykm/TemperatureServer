package pl.marczyk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marczyk.domain.TemperatureRepository;
import pl.marczyk.model.Temperature;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by marcin on 14.11.15.
 */
@Service
public class DataService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    public ChartData getLatestDataWithLabels() {
        ChartData chartData = new ChartData();
        List<Temperature> latestTemperatures = temperatureRepository.findFirst10ByOrderByTimestampDesc();
        double[] data = new double[latestTemperatures.size()];
        String[] labels = new String[latestTemperatures.size()];

        for (int i = 0; i < latestTemperatures.size(); i++){
            data[i] = latestTemperatures.get(i).getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            labels[i] = sdf.format(latestTemperatures.get(i).getTimestamp());
        }

        Dataset dataset = new Dataset(data);
        Dataset[] datasets = new Dataset[1];
        datasets[0] = dataset;
        chartData.setDatasets(datasets);
        chartData.setLabels(labels);

        return chartData;
    }

    public Temperature getLatestOne() {
        Temperature temperature = temperatureRepository.findFirstByOrderByTimestampDesc();

        return temperature;
    }
}
