public class Car extends Vehicle {
    public Car(String registrationNumber) {
        this.type = "Car";
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String getEntryTime() {
        return this.entryTime;
    }

    @Override
    public String getExitTime() {
        return this.exitTime;
    }

    @Override
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
