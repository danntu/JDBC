package by.bsu.data.subject;

public class Abonent extends Entity{
    private int age;
    private String last;

    public Abonent(){

    }
    public Abonent(int id, int age, String last){
        super(id);
        this.age=age;
        this.last=last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String toString(){
        return "Employee [ id = "+getId()+", age = "+age+", last = "+last+"]\n";
    }
}
