package stream.majorleague;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SalaryAnalyzer02 {
    public static void main(String[] args) throws IOException {
        // 1. 2016 LAD 평균연봉
        Path file = Paths.get(
                "/Users/soongonkim/Desktop/functional/src/main/resources/Salaries.csv");

        double averageSalary = Files.lines(file)  // Stream<String>  2016,TOR,AL,happja01,10000000
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
                })
                .filter(salary -> salary.getYear() == 2016)
                .filter(salary -> salary.getTeam().equals("LAD"))
                .mapToLong(salary -> salary.getSalary())
                .average()  // OptionalDouble
                .orElse(0);
        System.out.println(averageSalary);
    }
}
