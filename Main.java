class Course {
    private String name;
    private String instructor;
    private int credits;
    Course(String name, String instructor, int credits) {
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }
    String getName() {
        return name;
    }
    String getInstructor() {
        return instructor;
    }
    int getCredits() {
        return credits;
    }
    public String toString() {
        return "Course{name='" + name + "', instructor='"
                + instructor + "', credits=" + credits + "}";
    }
}
class AssignmentTask {
    private String title;
    private Course course;
    private int estimatedHours;
    private int daysUntilDue;
    private boolean completed;
    AssignmentTask(String title, Course course,
                   int estimatedHours, int daysUntilDue) {
        this.title = title;
        this.course = course;
        this.estimatedHours = estimatedHours;
        this.daysUntilDue = daysUntilDue;
        this.completed = false;
    }
    String getTitle() { return title; }
    Course getCourse() { return course; }
    int getEstimatedHours() { return estimatedHours; }
    int getDaysUntilDue() { return daysUntilDue; }
    boolean isCompleted() { return completed; }
    void markCompleted() {
        completed = true;
    }
    boolean isUrgent() {
        return daysUntilDue <= 2 && !completed;
    }
    public String toString() {
        return "AssignmentTask{title='" + title +
                "', course='" + course.getName() +
                "', estHours=" + estimatedHours +
                ", dueIn=" + daysUntilDue +
                ", completed=" + completed + "}";
    }
}
class StudySession {
    private Course course;
    private int minutes;
    StudySession(Course course, int minutes) {
        this.course = course;
        this.minutes = minutes;
    }
    Course getCourse() { return course; }
    int getMinutes() { return minutes; }
    double hours() {
        return minutes / 60.0;
    }
    public String toString() {
        return "StudySession{course='" +
                course.getName() + "', minutes=" + minutes + "}";
    }
}
public class Main {
    public static void main(String[] args) {
        //  Courses
        Course oop = new Course("OOP", "Dr. Lee", 6);
        Course math = new Course("Discrete Math", "Dr. Kim", 3);
        Course english = new Course("English", "Dr. Brown", 3);
        Course[] courses = {oop, math, english};
        System.out.println("Courses:");
        for (Course c : courses) {
            System.out.println(c);
        }
        //  Assignments
        AssignmentTask a1 = new AssignmentTask("Lab", oop, 3, 1);
        AssignmentTask a2 = new AssignmentTask("Project", oop, 10, 5);
        AssignmentTask a3 = new AssignmentTask("Hw", math, 4, 2);
        AssignmentTask a4 = new AssignmentTask("Essay", english, 5, 7);
        AssignmentTask[] tasks = {a1, a2, a3, a4};
        System.out.println("\nAssignments:");
        int totalHours = 0;
        for (AssignmentTask t : tasks) {
            System.out.println(t);
            if (!t.isCompleted()) {
                totalHours += t.getEstimatedHours();
            }
            if (t.isUrgent()) {
                System.out.println("Urgent!");
            }
        }
        System.out.println("\nTotal remaining hours: " + totalHours);
        //  Study Sessions
        StudySession s1 = new StudySession(oop, 90);
        StudySession s2 = new StudySession(oop, 60);
        StudySession s3 = new StudySession(math, 120);
        StudySession s4 = new StudySession(english, 30);
        StudySession[] sessions = {s1, s2, s3, s4};
        double oopHours = 0;
        double mathHours = 0;
        double engHours = 0;
        for (StudySession s : sessions) {
            if (s.getCourse() == oop) {
                oopHours += s.hours();
            }
            if (s.getCourse() == math) {
                mathHours += s.hours();
            }
            if (s.getCourse() == english) {
                engHours += s.hours();
            }
        }
        System.out.println("\nStudy time:");
        System.out.println("OOP: " + oopHours + " hours");
        System.out.println("Discrete Math: " + mathHours + " hours");
        System.out.println("English: " + engHours + " hours");
        //  Mark completed
        a1.markCompleted();
        System.out.println("\nUpdated assignment:");
        System.out.println(a1);
        totalHours = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalHours += t.getEstimatedHours();
            }
        }
        System.out.println("New remaining hours: " + totalHours);
    }
}