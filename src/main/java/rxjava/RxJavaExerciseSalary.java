package rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import stream.majorleague.Salary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RxJavaExerciseSalary {
    public static void main(String[] args) throws IOException {
        // 목적 : 2010년도 LAD 의 최고 연봉자 top 5를 구하라
        Path file = Paths.get(
                "/Users/soongonkim/Desktop/functional/src/main/resources/Salaries.csv");

        Stream<Salary> salaryStream = Files.lines(file)  // Stream<String>  2016,TOR,AL,happja01,10000000
                .skip(1)           // Stream<Salary>
                .map(line -> {
                    String[] splitted = line.split(",");
                    return new Salary(
                            Integer.parseInt(splitted[0]),
                            splitted[1],
                            splitted[2],
                            splitted[3],
                            Long.parseLong(splitted[4])
                    );
                });

        // Stream<Salary> --> Flowable<Salary>
        Flowable.fromStream(salaryStream)
                .filter(salary -> salary.getYear() == 2016)
                .filter(salary -> salary.getTeam().equals("LAD"))
                .sorted((a, b) -> (int)(b.getSalary() - a.getSalary()))
                .take(5)
                .subscribe(System.out::println);
    }
}
