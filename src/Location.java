import java.util.ArrayList;
import java.util.List;

public class Location {

    private String city;
    private double averageSalary;
    private int numberOfJobs;
    private List<Job> jobs;


    public Location() {
        this.city = null;
        this.averageSalary = 0;
        this.numberOfJobs = 0;
        this.jobs = new ArrayList<Job>();
    }

    public void addJob(Job job) {
        this.jobs.add(job);
        this.numberOfJobs++;
    }


    public int getNumberOfJobs() {
        return this.numberOfJobs;
    }

    public List<Job> getJobs() {
        return this.jobs;
    }

    public double getAverageSalary() {
        return this.averageSalary/jobs.size();
    }




    // ********************    SETTERS    *************************** //


    public void setAverageSalary(double value) {
        this.averageSalary = value;
    }

}
