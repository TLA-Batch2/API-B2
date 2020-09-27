package pojo.dummyAPI;

public class Employee {
    private String status;
    private String message;
    private EmployeeData data;

    public Employee(String status, String message, EmployeeData data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EmployeeData getData() {
        return data;
    }

    public void setData(EmployeeData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "\n\tstatus = " + status +
                "\n\tmessage = " + message +
                "\n\tData = " + data +
                "\n\t}";
    }
}
