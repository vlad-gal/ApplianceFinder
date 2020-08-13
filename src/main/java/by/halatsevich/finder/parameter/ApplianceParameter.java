package by.halatsevich.finder.parameter;

public enum ApplianceParameter {
    NAME("NAME"),
    POWER_CONSUMPTION("POWER_CONSUMPTION"),
    WEIGHT("WEIGHT"),
    CAPACITY("CAPACITY"),
    DEPTH("DEPTH"),
    HEIGHT("HEIGHT"),
    WIDTH("WIDTH"),
    BATTERY_CAPACITY("BATTERY_CAPACITY"),
    OS("OS"),
    MEMORY_ROM("MEMORY_ROM"),
    SYSTEM_MEMORY("SYSTEM_MEMORY"),
    DISPLAY_INCHES("DISPLAY_INCHES"),
    CPU("CPU"),
    FREEZER_CAPACITY("FREEZER_CAPACITY"),
    OVERALL_CAPACITY("OVERALL_CAPACITY"),
    FILTER_TYPE("FILTER_TYPE"),
    BAG_TYPE("BAG_TYPE"),
    WAND_TYPE("WAND_TYPE"),
    MOTOR_SPEED_REGULATION("MOTOR_SPEED_REGULATION"),
    CLEANING_WIDTH("CLEANING_WIDTH"),
    FLASH_MEMORY_CAPACITY("FLASH_MEMORY_CAPACITY"),
    COLOR("COLOR"),
    NUMBER_OF_SPEAKERS("NUMBER_OF_SPEAKERS"),
    FREQUENCY_RANGE("FREQUENCY_RANGE"),
    CORD_LENGTH("CORD_LENGTH");

    private String parameterName;

    ApplianceParameter(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }
}
