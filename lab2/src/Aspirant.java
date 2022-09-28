public class Aspirant extends Student {

    public Aspirant(String firstname, String lastname, String group, double averagemark){
        super(firstname, lastname, group, averagemark);
    }

    public int getScholarship() {
        if (this.getAverageMark() == 5) {
            return 200;
        }
        else {
            return 180;
        }
    }
}