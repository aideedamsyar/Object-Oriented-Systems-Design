package Week6.Exercise1;

import java.time.LocalDate;

public class AgeCalculator {

    public static int calAge(Person p) {
        LocalDate now = LocalDate.now();
        int year = p.getBirthYear();
        int month = p.getBirthMonth();
        int day = p.getBirthDay();

        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();
        int currentDay = now.getDayOfMonth();

        int age = currentYear - year;

        if ((currentMonth >= month) && (currentDay >= day)) {
            return ++age;
        } else {
            return age;
        }
    }


    public static int isOlder(Person p1, Person p2) {
        int age_p1 = calAge(p1);
        int age_p2 = calAge(p2);

        if (age_p1 > age_p2) {
            System.out.printf("%s is older than %s\n", p1.getName(), p2.getName());
            return 1;
        } else if (age_p1 == age_p2) {
            System.out.printf("%s and %s are of the same age\n", p1.getName(), p2.getName());
            return 0;
        } else {
            System.out.printf("%s is older than %s\n", p2.getName(), p1.getName());
            return -1;
        }
    }
}

