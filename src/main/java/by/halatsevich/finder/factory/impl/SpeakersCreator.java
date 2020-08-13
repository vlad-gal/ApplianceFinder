package by.halatsevich.finder.factory.impl;

import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.entity.Speakers;
import by.halatsevich.finder.factory.ApplianceCreator;
import by.halatsevich.finder.parameter.ApplianceParameter;

import java.util.Map;

public class SpeakersCreator implements ApplianceCreator {
    private static final String REGEX_HYPHEN = "-";

    @Override
    public Appliance createAppliance(Map<String, String> applianceParameter) {
        Speakers speakers = new Speakers();
        double powerConsumption = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.POWER_CONSUMPTION.getParameterName()));
        int numberOfSpeakers = Integer
                .parseInt(applianceParameter.get(ApplianceParameter.NUMBER_OF_SPEAKERS.getParameterName()));
        double startFrequencyRange = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.FREQUENCY_RANGE.getParameterName()).split(REGEX_HYPHEN)[0]);
        double endFrequencyRange = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.FREQUENCY_RANGE.getParameterName()).split(REGEX_HYPHEN)[1]);
        double cordLength = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.CORD_LENGTH.getParameterName()));
        speakers.setPowerConsumption(powerConsumption);
        speakers.setNumberOfSpeakers(numberOfSpeakers);
        speakers.setStartFrequencyRange(startFrequencyRange);
        speakers.setEndFrequencyRange(endFrequencyRange);
        speakers.setCordLength(cordLength);
        return speakers;
    }
}
