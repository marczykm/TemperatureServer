package pl.marczyk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by marcin on 14.11.15.
 */
@Entity
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date timestamp;

    @NotNull
    private double value;

    public Temperature() {
    }

    public Temperature(Date timestamp, double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", value=" + value +
                '}';
    }
}
