public class Student {
    public String firstname;
    public String lastname;
    public String group;
    public double averagemark;

    public Student(String firstname, String lastname, String group, double averagemark){
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
        this.averagemark = averagemark;
    }

    public int getScholarship() {
        if (this.getAverageMark() == 5) {
            return 100;
        }
        else {
            return 80;
        }
    }

    public double getAverageMark() {
        return this.averagemark;
    }
}