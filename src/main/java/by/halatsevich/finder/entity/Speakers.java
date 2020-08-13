package by.halatsevich.finder.entity;

public class Speakers extends Appliance{
    private double powerConsumption;
    private int numberOfSpeakers;
    private double startFrequencyRange;
    private double endFrequencyRange;
    private double cordLength;

    public Speakers() {
        super(Speakers.class.getSimpleName());
    }

    public Speakers(double powerConsumption, int numberOfSpeakers, double startFrequencyRange, double endFrequencyRange, double cordLength) {
        super(Speakers.class.getSimpleName());
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.startFrequencyRange = startFrequencyRange;
        this.endFrequencyRange = endFrequencyRange;
        this.cordLength = cordLength;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public double getStartFrequencyRange() {
        return startFrequencyRange;
    }

    public void setStartFrequencyRange(double startFrequencyRange) {
        this.startFrequencyRange = startFrequencyRange;
    }

    public double getEndFrequencyRange() {
        return endFrequencyRange;
    }

    public void setEndFrequencyRange(double endFrequencyRange) {
        this.endFrequencyRange = endFrequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Speakers speakers = (Speakers) o;

        if (Double.compare(speakers.powerConsumption, powerConsumption) != 0) return false;
        if (numberOfSpeakers != speakers.numberOfSpeakers) return false;
        if (Double.compare(speakers.startFrequencyRange, startFrequencyRange) != 0) return false;
        if (Double.compare(speakers.endFrequencyRange, endFrequencyRange) != 0) return false;
        return Double.compare(speakers.cordLength, cordLength) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(powerConsumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numberOfSpeakers;
        temp = Double.doubleToLongBits(startFrequencyRange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(endFrequencyRange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cordLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Speakers{");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", numberOfSpeakers=").append(numberOfSpeakers);
        sb.append(", startFrequencyRange=").append(startFrequencyRange);
        sb.append(", endFrequencyRange=").append(endFrequencyRange);
        sb.append(", cordLength=").append(cordLength);
        sb.append('}');
        return sb.toString();
    }
}

