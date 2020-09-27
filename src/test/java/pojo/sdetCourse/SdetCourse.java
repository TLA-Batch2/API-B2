package pojo.sdetCourse;

import java.util.List;

public class SdetCourse {
    List<Course> data;

    public SdetCourse(List<Course> data) {
        this.data = data;
    }

    public List<Course> getData() {
        return data;
    }

    public void setData(List<Course> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SdetCourse{" +
                "data=" + data +
                '}';
    }
}
