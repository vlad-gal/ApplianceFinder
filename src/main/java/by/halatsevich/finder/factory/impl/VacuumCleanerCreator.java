package by.halatsevich.finder.factory.impl;

import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.entity.VacuumCleaner;
import by.halatsevich.finder.factory.ApplianceCreator;
import by.halatsevich.finder.parameter.ApplianceParameter;

import java.util.Map;

public class VacuumCleanerCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(Map<String, String> applianceParameter) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        double powerConsumption = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.POWER_CONSUMPTION.getParameterName()));
        String filterType = applianceParameter.get(ApplianceParameter.FILTER_TYPE.getParameterName());
        String bagType = applianceParameter.get(ApplianceParameter.BAG_TYPE.getParameterName());
        String wandType = applianceParameter.get(ApplianceParameter.WAND_TYPE.getParameterName());
        double motorSpeedRegulation = Integer
                .parseInt(applianceParameter.get(ApplianceParameter.MOTOR_SPEED_REGULATION.getParameterName()));
        double cleaningWidth = Double
                .parseDouble(applianceParameter.get(ApplianceParameter.CLEANING_WIDTH.getParameterName()));
        vacuumCleaner.setPowerConsumption(powerConsumption);
        vacuumCleaner.setFilterType(filterType);
        vacuumCleaner.setBagType(bagType);
        vacuumCleaner.setWandType(wandType);
        vacuumCleaner.setMotorSpeedRegulation(motorSpeedRegulation);
        vacuumCleaner.setCleaningWidth(cleaningWidth);
        return vacuumCleaner;
    }
}
