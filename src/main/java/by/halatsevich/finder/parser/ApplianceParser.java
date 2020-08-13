package by.halatsevich.finder.parser;

import by.halatsevich.finder.parameter.ApplianceParameter;

import java.util.HashMap;
import java.util.Map;

public class ApplianceParser {
    private static final String REGEX_DELIMITER = "(\\s:\\s)|(,\\s)";
    private static final String REGEX_EQUAL = "=";

    public Map<String, String> parseAppliance(String applianceData) {
        String[] splitData = applianceData.split(REGEX_DELIMITER);
        Map<String, String> parsedData = new HashMap<>();
        parsedData.put(ApplianceParameter.NAME.getParameterName(), splitData[0].toUpperCase());
        for (int i = 1; i < splitData.length; i++) {
            String[] parameters = splitData[i].toUpperCase().split(REGEX_EQUAL);
            parsedData.put(parameters[0], parameters[1]);
        }
        return parsedData;
    }
}
