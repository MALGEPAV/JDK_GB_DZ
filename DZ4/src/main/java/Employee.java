public class Employee {
    private final int ID;
    private String phoneNumber;
    private String name;
    private int workExperience;

    public Employee(int ID, String phoneNumber, String name, int workExperience) {
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workExperience = workExperience;
    }

    public int getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    @Override
    public String toString() {
        return String.format("ID: %d; NAME: %s; EXP: %d; PHONE: %s\n"
                , ID, name, workExperience, phoneNumber);
    }
}
