package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Person james = new Person("James", 0.096, 0.415, 0.489, 0.6);
        Person george = new Person("George", 0.096, 0.415, 0.489, 0.4);

        ArrayList<Company> jamesCompanies = new ArrayList<>();
        jamesCompanies.add(new Company("BidonGames", 0.5, 0.2, 0.2));
        jamesCompanies.add(new Company("TitaniumLabs", 0.45, 0.3, 0.5));
        jamesCompanies.add(new Company("Google", 0.05, 0.6, 0.2));

        ArrayList<Company> georgeCompanies = new ArrayList<>();
        georgeCompanies.add(new Company("BidonGames", 0.35, 0.2, 0.1));
        georgeCompanies.add(new Company("TitaniumLabs", 0.5, 0.3, 0.6));
        georgeCompanies.add(new Company("Google", 0.05, 0.5, 0.3));


        List<Double> jamesSetPoints = james.getCompanyPointsFrom(jamesCompanies);
        List<Double> georgeSetPoints = george.getCompanyPointsFrom(georgeCompanies);

        List<Double> result = IntStream.range(0, jamesCompanies.size())
                .parallel()
                .mapToObj(i -> jamesSetPoints.get(i) * james.getCompetition()
                        + georgeSetPoints.get(i) * george.getCompetition())
                .collect(Collectors.toList());

        System.out.println(james.getName() + " opinion: ");
        show(jamesCompanies, jamesSetPoints);

        System.out.println(george.getName() + " opinion: ");
        show(georgeCompanies, georgeSetPoints);

        System.out.println("Common result: ");
        show(georgeCompanies, result);

        System.out.println("Optimal variant is to choose : "
                + georgeCompanies.get(result.indexOf(Collections.max(result))).getName()
                + " because it have maximum result = "
                + Collections.max(result));
    }

    private static void show(ArrayList<Company> companies, List<Double> points) {
        IntStream.range(0, companies.size())
                .mapToObj(i -> "\t" + companies.get(i).getName() + " = " + points.get(i))
                .forEach(System.out::println);
    }
}
