package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private double place;
    private double salary;
    private double requirements;
    private double competition;

    Person(String name, double place, double salary, double requirements, double competition) {
        this.name = name;
        this.place = place;
        this.salary = salary;
        this.requirements = requirements;
        this.competition = competition;
    }

    String getName() {
        return name;
    }

    double getCompetition() {
        return competition;
    }

    List<Double> getCompanyPointsFrom(ArrayList<Company> companies) {
        return companies.stream()
                .map(it -> it.getPoints(place, salary, requirements) / 2)
                .collect(Collectors.toList());
    }
}
