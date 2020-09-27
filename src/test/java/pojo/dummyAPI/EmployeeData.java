package pojo.dummyAPI;

public class EmployeeData {
    private String employee_name;
    private String profile_image;
    private int employee_salary;
    private int employee_age;

    public EmployeeData(String employee_name, String profile_image, int employee_salary, int employee_age) {
        this.employee_name = employee_name;
        this.profile_image = profile_image;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    @Override
    public String toString() {
        return "\n\tEmployeeData {" +
                "\n\temployee_name = " + employee_name +
                "\n\tprofile_image = " + profile_image +
                "\n\temployee_salary = " + employee_salary +
                "\n\temployee_age=" + employee_age +
                "\n\t}";
    }
}
