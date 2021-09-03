package stream.majorleague;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SalaryAnalyzer {
    public static void main(String[] args) throws IOException {
        // 핵심 : salary.csv --> Stream<Salary>

        //1. File 객체를 생성 --> Path 객체로 변경
        Path file = Paths.get("/Users/soongonkim/Desktop/functional/src/main/resources/Salaries.csv");

        Files.lines(file)  // Stream<String>  2016,TOR,AL,happja01,10000000
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
                .limit(100)
                .forEach(System.out::println);
    }
}
