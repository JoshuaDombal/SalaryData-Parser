public class Job {

    private String name;
    private String company;
    private String state;
    private String city;
    private String strSalary;
    private double salary;


    public Job(String name, String company, String state, String city, double salary) {
        this.name = name;
        this.company = company;
        this.state = state;
        this.city = city;
        this.salary = salary;
    }


    public double getSalary() {
        return this.salary;
    }

}
