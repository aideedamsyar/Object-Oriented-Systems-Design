package Week6.Exercise1;

public class Person {
    private String name;
    private int birthYear, birthMonth, birthDay;

    public Person(String _name, int _birthYear, int _birthMonth, int _birthDay) {
        this.name = _name;
        this.birthYear = _birthYear;
        this.birthMonth = _birthMonth;
        this.birthDay = _birthDay;
    }

    public String getName(){
        return this.name;
    }
    public int getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(int _birthYear) {
        this.birthYear = _birthYear;
    }

    public int getBirthMonth() {
        return this.birthMonth;
    }

    public void setBirthMonth(int _birthMonth) {
        this.birthMonth = _birthMonth;
    }

    public int getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(int _birthDay) {
        this.birthDay = _birthDay;
    }


}
