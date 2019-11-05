package sample;

class Company {
    private String name;
    private double place;
    private double salary;
    private double requirements;

    Company(String name, double place, double salary, double requirements) {
        this.name = name;
        this.place = place;
        this.salary = salary;
        this.requirements = requirements;
    }

    String getName() {
        return name;
    }

    double getPoints(double place, double salary, double requirements) {
        //System.out.println(name +": " + this.place +"*"+ place + "+" + this.salary +"*"+ salary +"+"+ this.requirements +"*"+ requirements + "=" + (this.place * place + this.salary * salary + this.requirements * requirements)/2);
        return this.place * place + this.salary * salary + this.requirements * requirements;
    }
}
