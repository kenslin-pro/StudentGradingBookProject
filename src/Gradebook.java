import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public void updateGrade(int index, double newGrade) {
        if (index >= 0 && index < grades.size()) {
            grades.set(index, newGrade);
        }
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public String getName() {
        return name;
    }
}

public class Gradebook {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Gradebook Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Update Grade");
            System.out.println("4. Calculate Average Grade");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student's name: ");
                    String studentName = scanner.next();
                    students.add(new Student(studentName));
                    System.out.println("Student added.");
                    break;
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students in the gradebook. Add a student first.");
                        break;
                    }
                    System.out.print("Enter the student's name: ");
                    String searchName = scanner.next();
                    System.out.print("Enter the grade: ");
                    double grade = scanner.nextDouble();

                    for (Student student : students) {
                        if (student.getName().equals(searchName)) {
                            student.addGrade(grade);
                            System.out.println("Grade added.");
                            break;
                        }
                    }
                    break;
                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students in the gradebook. Add a student first.");
                        break;
                    }
                    System.out.print("Enter the student's name: ");
                    String updateName = scanner.next();
                    System.out.print("Enter the index of the grade to update: ");
                    int gradeIndex = scanner.nextInt();
                    System.out.print("Enter the new grade: ");
                    double newGrade = scanner.nextDouble();

                    for (Student student : students) {
                        if (student.getName().equals(updateName)) {
                            student.updateGrade(gradeIndex, newGrade);
                            System.out.println("Grade updated.");
                            break;
                        }
                    }
                    break;
                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students in the gradebook. Add a student first.");
                        break;
                    }
                    System.out.print("Enter the student's name: ");
                    String calculateName = scanner.next();

                    for (Student student : students) {
                        if (student.getName().equals(calculateName)) {
                            double average = student.calculateAverageGrade();
                            System.out.println("Average grade for " + student.getName() + ": " + average);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting the gradebook program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
