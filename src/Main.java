import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static HashMap<String, ArrayList<String>> enroll = new HashMap<>();

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\n1.Register\n2.Add Course\n3.Enroll\n4.Students\n5.Courses\n6.Student Load\n0.Exit");
            ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Program(BSIT/BSCS): ");
                    String prog = sc.nextLine().toUpperCase();
                    System.out.print("Year: ");
                    int year = Integer.parseInt(sc.nextLine());
                    students.add(new Student(id, name, prog, year));
                    System.out.println("Registered!");
                    break;

                case 2:
                    System.out.print("Code: ");
                    String code = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Units: ");
                    int units = Integer.parseInt(sc.nextLine());
                    System.out.print("Capacity: ");
                    int cap = Integer.parseInt(sc.nextLine());
                    courses.add(new Course(code, title, units, cap));
                    System.out.println("Course Added!");
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    String sid = sc.nextLine();
                    System.out.print("Course Code: ");
                    String cc = sc.nextLine();

                    Student s = findStudent(sid);
                    Course c = findCourse(cc);

                    if (s == null || c == null) {
                        System.out.println("Student/Course Not Found!");
                        break;
                    }
                    if (c.isFull()) {
                        System.out.println("Course Full!");
                        break;
                    }

                    enroll.putIfAbsent(sid, new ArrayList<>());
                    if (!enroll.get(sid).contains(cc)) {
                        enroll.get(sid).add(cc);
                        c.addOneEnrollee();
                        System.out.println("Enrolled!");
                    } else
                        System.out.println("Already Enrolled!");
                    break;

                case 4:
                    for (Student st : students)
                        System.out.println(st.describe());
                    break;

                case 5:
                    for (Course co : courses)
                        System.out.println(co.getCourseCode() + " | " + co.getTitle() + " | " + co.getEnrolledCount() + "/" + co.getCapacity());
                    break;

                case 6:
                    System.out.print("Student ID: ");
                    sid = sc.nextLine();
                    if (!enroll.containsKey(sid)) {
                        System.out.println("No Courses.");
                        break;
                    }
                    int total = 0;
                    for (String x : enroll.get(sid)) {
                        Course co = findCourse(x);
                        System.out.println(co.getCourseCode() + " - " + co.getTitle());
                        total += co.getUnits();
                    }
                    System.out.println("Total Units: " + total);
                    break;
            }
        } while (ch != 0);

        System.out.println("Thank you!");
    }

    static Student findStudent(String id) {
        for (Student s : students)
            if (s.getStudentId().equals(id))
                return s;
        return null;
    }

    static Course findCourse(String code) {
        for (Course c : courses)
            if (c.getCourseCode().equals(code))
                return c;
        return null;
    }
}