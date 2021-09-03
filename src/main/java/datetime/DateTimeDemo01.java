package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeDemo01 {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalDateTime todaynow = LocalDateTime.now();
        System.out.println(todaynow);

        LocalDate lastChristmas = LocalDate.of(2020, 12, 25);
        System.out.println(lastChristmas);

        LocalDate whenwemet = lastChristmas.minusDays(100);
        System.out.println(whenwemet);
        DayOfWeek dayOfWeek = whenwemet.getDayOfWeek();
        System.out.println(dayOfWeek);

        // 2001.9.11.. 300일 후의 2달 전은 언제일까요?
        LocalDate theDay = LocalDate.of(2001, 9, 11)
                .plusDays(300)
                .minusMonths(2);
        System.out.println(theDay);

        // 현재시각의 세 시간전의 20분후?
        LocalTime then = LocalTime.now()
                .minusHours(3)
                .plusMinutes(20);
        System.out.println(then);
    }
}
