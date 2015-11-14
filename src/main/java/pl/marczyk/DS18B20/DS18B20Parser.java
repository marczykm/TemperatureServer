package pl.marczyk.DS18B20;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by marcin on 14.11.15.
 */
@Component
public class DS18B20Parser {
    private final Logger LOG = LogManager.getRootLogger();

    public final String W1_DEVICES_PATH = "/sys/bus/w1/devices/";
    public final String W1_SLAVE = "/w1_slave";
    private String deviceName; // Argument to point 28-000xxxx

    public DS18B20Parser(){

    }

    public void init(String deviceName){
        this.deviceName = deviceName;
    }

    public double getTemperature() throws Exception {
        if (this.deviceName == null) {
            throw new Exception("Class not initialized");
        }
        return readTempFromFile(getFullPathToDevice(deviceName));
    }

    private Path getFullPathToDevice(String deviceFileName){
        return FileSystems.getDefault().getPath(W1_DEVICES_PATH+deviceFileName+W1_SLAVE);
    }

    private double readTempFromFile(Path pathDeviceFile) throws Exception {
        int iniPos, endPos;
        String strTemp, strTempIdentifier = "t=";
        double tvalue = 0;
        List<String> lines = null;

        try {
            lines = Files.readAllLines(pathDeviceFile, Charset.defaultCharset());
        } catch (IOException e) {
            throw new Exception("No device detected named: " + deviceName);
        }
        for(String line : lines){
            if(line.contains(strTempIdentifier)){
                iniPos = line.indexOf(strTempIdentifier)+2;
                endPos = line.length();
                strTemp = line.substring(iniPos, endPos);
                tvalue = Double.parseDouble(strTemp) / 1000;
            }
        }
        return tvalue;
    }
}
