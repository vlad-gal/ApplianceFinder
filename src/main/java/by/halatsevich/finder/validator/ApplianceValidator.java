package by.halatsevich.finder.validator;

import by.halatsevich.finder.parameter.ApplianceParameter;
import by.halatsevich.finder.parameter.ApplianceType;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceValidator {
    private static final String REGEX_VALUE = "(\\d+\\.\\d+)|(\\d+)|([\\p{Alpha}-]+)|([\\p{Alpha}\\d-]+)";

    public boolean isValidApplianceName(String applianceName) {
        ApplianceType[] applianceNames = ApplianceType.values();
        boolean flag = false;
        for (int i = 0; i < applianceNames.length; i++) {
            if (applianceName.equalsIgnoreCase(applianceNames[i].name())){
                flag = true;
            }
        }
        return flag;
    }

    public boolean isValidApplianceParameter(String applianceParameter) {
        ApplianceParameter[] applianceParameters = ApplianceParameter.values();
        boolean flag = false;
        for (int i = 0; i < applianceParameters.length; i++) {
            if (applianceParameter.equalsIgnoreCase(applianceParameters[i].name())){
                flag = true;
            }
        }
        return flag;
    }

    public boolean isValidApplianceParameterValue(String applianceParameter) {
        Pattern pattern = Pattern.compile(REGEX_VALUE);
        Matcher matcher = pattern.matcher(applianceParameter);
        return matcher.find();
    }
}
