public abstract class Vehicle {
    protected String type;
    protected String registrationNumber;
    protected String entryTime, exitTime;

    public abstract String getType();

    public abstract String getExitTime();

    public abstract void setExitTime(String exitTime);

    public abstract String getEntryTime();

    public abstract void setEntryTime(String entryTime);

    public abstract String getRegistrationNumber();

    public abstract void setRegistrationNumber(String registrationNumber);
}
