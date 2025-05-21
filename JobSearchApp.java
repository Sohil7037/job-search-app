import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Job {
    String title;
    String company;
    String location;
    String description;

    public Job(String title, String company, String location, String description) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Job Title: " + title + "\nCompany: " + company + "\nLocation: " + location + "\nDescription: " + description + "\n";
    }
}

public class JobSearchApp {
    private List<Job> jobs;

    public JobSearchApp() {
        jobs = new ArrayList<>();
        loadJobs();
    }

    private void loadJobs() {
        jobs.add(new Job("Java Developer", "Infosys", "Bangalore", "Looking for Java developers with 2+ years experience."));
        jobs.add(new Job("Frontend Developer", "TCS", "Mumbai", "React and Angular developer needed."));
        jobs.add(new Job("Data Scientist", "Google India", "Bangalore", "Experienced with machine learning and data analytics."));
        jobs.add(new Job("Backend Developer", "Amazon", "Hyderabad", "Proficient in Java and Spring Boot."));
        jobs.add(new Job("Full Stack Developer", "Wipro", "Chennai", "Experience with Java, React, and SQL."));
        jobs.add(new Job("Mobile App Developer", "Flipkart", "Bangalore", "Android and iOS app development."));
        // Add more jobs as needed
    }

    public void searchJobs(String keyword, String location) {
        boolean found = false;
        for (Job job : jobs) {
            if ((keyword == null || job.title.toLowerCase().contains(keyword.toLowerCase()) || job.description.toLowerCase().contains(keyword.toLowerCase()))
                    && (location == null || job.location.equalsIgnoreCase(location))) {
                System.out.println(job);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No jobs found matching your criteria.");
        }
    }

    public static void main(String[] args) {
        JobSearchApp app = new JobSearchApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Job Search India");
        System.out.print("Enter keyword to search (or press Enter to skip): ");
        String keyword = scanner.nextLine().trim();
        if (keyword.isEmpty()) keyword = null;

        System.out.print("Enter location to filter by (or press Enter to skip): ");
        String location = scanner.nextLine().trim();
        if (location.isEmpty()) location = null;

        System.out.println("\nSearch Results:");
        app.searchJobs(keyword, location);

        scanner.close();
    }
}