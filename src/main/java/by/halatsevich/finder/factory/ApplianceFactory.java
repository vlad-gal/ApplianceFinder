package by.halatsevich.finder.factory;

import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.factory.impl.*;
import by.halatsevich.finder.parameter.ApplianceParameter;
import by.halatsevich.finder.parameter.ApplianceType;

import java.util.Map;

public class ApplianceFactory {

    public Appliance createAppliance(Map<String, String> applianceParameter) {
        String applianceName = applianceParameter.get(ApplianceParameter.NAME.getParameterName());
        ApplianceType applianceType = ApplianceType.valueOf(applianceName);
        ApplianceCreator creator;
        Appliance appliance = null;
        switch (applianceType) {
            case OVEN:
                creator = new OvenCreator();
                appliance = creator.createAppliance(applianceParameter);
                break;
            case LAPTOP:
                creator = new LaptopCreator();
                appliance = creator.createAppliance(applianceParameter);
                break;
            case SPEAKERS:
                creator = new SpeakersCreator();
                appliance = creator.createAppliance(applianceParameter);
                break;
            case TABLETPC:
                creator = new TabletPCCreator();
                appliance = creator.createAppliance(applianceParameter);
                break;
            case VACUUMCLEANER:
                creator = new VacuumCleanerCreator();
                appliance = creator.createAppliance(applianceParameter);
                break;
            case REFRIGERATOR:
                creator = new RefrigeratorCreator();
                appliance = creator.createAppliance(applianceParameter);
                break;
        }
        return appliance;
    }
}
