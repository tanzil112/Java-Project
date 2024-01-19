import java.util.Scanner;

class Student {
private String name;
private int age;
private String grade;

public Student(String name, int age, String grade) {
this.name = name;
this.age = age;
this.grade = grade;
}

public String getName() {
return name;
}

public void displayDetails() {
System.out.println("Student Details:");
System.out.println("Name: " + name);
System.out.println("Age: " + age);
System.out.println("Grade: " + grade);
displayRemarks(); // Display custom remarks based on grade
System.out.println("--------------");
}

private void displayRemarks() {
switch (grade.toUpperCase()) {
case "A":
System.out.println("Remarks: Sky is the limit!");
break;
case "B":
System.out.println("Remarks: Good, but try harder.");
break;
case "C":
System.out.println("Remarks: Work hard for better results.");
break;
default:
System.out.println("Remarks: No specific remarks for this grade.");
}
}
}

public class StudentManagementSystem {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int studentCount;

System.out.print("Enter the number of students: ");
studentCount = scanner.nextInt();

// Create an array to store students
Student[] students = new Student[studentCount];

// Input student details
for (int i = 0; i < studentCount; i++) {
System.out.println("\nEnter details for Student " + (i + 1) + ":");
System.out.print("Name: ");
scanner.nextLine(); // Consume the newline character
String name = scanner.nextLine();
System.out.print("Age: ");
int age = scanner.nextInt();
System.out.print("Grade: ");
String grade = scanner.next();

// Create a new student object and add it to the array
students[i] = new Student(name, age, grade);
}

// Display details of all students
System.out.println("\nDetails of all students:");
for (Student student : students) {
student.displayDetails();
}

// Search for a student by name
System.out.print("\nEnter the name of the student to search: ");
scanner.nextLine(); // Consume the newline character
String searchName = scanner.nextLine();
boolean found = false;

for (Student student : students) {
if (student != null && student.getName().equalsIgnoreCase(searchName)) {
System.out.println("Student found:");
student.displayDetails();
found = true;
break;
}
}

if (!found) {
System.out.println("Student not found in the system.");
}

scanner.close();
}
}
