package pojo.sdetCourse;

public class Course {
    private String _id;
    private String duration;
    private String name;
    private int __v;

    public Course(String _id, String duration, String name, int __v) {
        this._id = _id;
        this.duration = duration;
        this.name = name;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    @Override
    public String toString() {
        return "Course{" +
                "_id='" + _id + '\'' +
                ", duration='" + duration + '\'' +
                ", name='" + name + '\'' +
                ", __v=" + __v +
                '}';
    }
}
