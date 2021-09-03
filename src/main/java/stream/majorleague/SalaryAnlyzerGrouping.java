package stream.majorleague;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class SalaryAnlyzerGrouping {
    public static void main(String[] args) throws IOException {
        // 1. TEAM 별로 그룹핑, 단 2015년도와 2016년도 데이터만 사용
        Path file = Paths.get(
                "/Users/soongonkim/Desktop/functional/src/main/resources/Salaries.csv");

        Map<String, DoubleSummaryStatistics> collect = Files.lines(file)  // Stream<String>  2016,TOR,AL,happja01,10000000
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
                .filter(salary -> salary.getYear() >= 2015)
                .collect(groupingBy(Salary::getTeam,
                        summarizingDouble(salary -> salary.getSalary())));
        System.out.println(collect.get("TEX").getAverage());
    }
}
