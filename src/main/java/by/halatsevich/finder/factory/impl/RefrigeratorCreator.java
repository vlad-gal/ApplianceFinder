package by.halatsevich.finder.factory.impl;

import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.entity.Refrigerator;
import by.halatsevich.finder.factory.ApplianceCreator;
import by.halatsevich.finder.parameter.ApplianceParameter;

import java.util.Map;

public class RefrigeratorCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(Map<String, String> applianceParameter) {
        Refrigerator refrigerator = new Refrigerator();
        double powerConsumption = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.POWER_CONSUMPTION.getParameterName()));
        double weight = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.WEIGHT.getParameterName()));
        double freezerCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.FREEZER_CAPACITY.getParameterName()));
        double overallCapacity = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.OVERALL_CAPACITY.getParameterName()));
        double height = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.HEIGHT.getParameterName()));
        double width = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.WIDTH.getParameterName()));
        refrigerator.setPowerConsumption(powerConsumption);
        refrigerator.setWeight(weight);
        refrigerator.setFreezerCapacity(freezerCapacity);
        refrigerator.setOverallCapacity(overallCapacity);
        refrigerator.setHeight(height);
        refrigerator.setWidth(width);
        return refrigerator;
    }
}
