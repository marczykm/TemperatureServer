package pl.marczyk.service;

/**
 * Created by marcin on 14.11.15.
 */
public class ChartData {
    private String[] labels;
    private Dataset[] datasets;

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Dataset[] getDatasets() {
        return datasets;
    }

    public void setDatasets(Dataset[] datasets) {
        this.datasets = datasets;
    }
}
