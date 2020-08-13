package by.halatsevich.finder.controller.command.impl;

import by.halatsevich.finder.controller.command.Command;
import by.halatsevich.finder.controller.command.CommandParameter;
import by.halatsevich.finder.entity.Appliance;
import by.halatsevich.finder.exception.ServiceException;
import by.halatsevich.finder.service.ApplianceService;
import by.halatsevich.finder.service.impl.ApplianceServiceImpl;
import org.apache.logging.log4j.Level;

import java.util.HashMap;
import java.util.Map;

public class FindApplianceCommand implements Command {
    @Override
    public Map<String, Object> execute(Map<String, String> applianceParameter) {
        ApplianceService applianceService = ApplianceServiceImpl.getInstance();
        Map<String, Object> result = new HashMap<>();
        Appliance appliance;
        try {
            appliance = applianceService.findAppliance(applianceParameter);
            result.put(CommandParameter.RESULT_KEY, appliance);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Error while finding appliance", e);
            result.put(CommandParameter.RESULT_KEY, e.getMessage());
        }
        return result;
    }
}
