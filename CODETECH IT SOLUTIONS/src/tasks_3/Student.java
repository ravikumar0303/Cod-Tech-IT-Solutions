package tasks_3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StudentData {
    String name;
    int rollNumber;
    Map<String, Integer> marks;
    double percentage;
    String grade;

    public StudentData(String name, int rollNumber, Map<String, Integer> marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
        calculatePercentage();
        calculateGrade();
    }

    public void calculatePercentage() {
        int totalMarks = 0;
        int totalSubjects = 0;

        for (int marks : this.marks.values()) {
            totalMarks += marks;
            totalSubjects++;
        }

        double maxPossibleMarks = totalSubjects * 100;
        percentage = (totalMarks / maxPossibleMarks) * 100;
    }


    public void calculateGrade() {
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B+";
        } else if (percentage >= 60) {
            grade = "B";
        } else {
            grade = "C";
        }
    }
}

class GradeManagementSystem {
    Map<Integer, StudentData> students;

    public GradeManagementSystem() {
        students = new HashMap<>();
    }

    public void addStudent(StudentData student) {
        students.put(student.rollNumber, student);
    }

    public void updateStudent(int rollNumber, Map<String, Integer> newMarks) {
        if (students.containsKey(rollNumber)) {
            StudentData student = students.get(rollNumber);
            student.marks = newMarks;
            student.calculatePercentage();
            student.calculateGrade();
            System.out.println("Student " + student.name + "'s record updated successfully.");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    public void deleteStudent(int rollNumber) {
        if (students.containsKey(rollNumber)) {
            students.remove(rollNumber);
            System.out.println("Student with roll number " + rollNumber + " deleted successfully.");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }
    
    public void printStudentList() {
        System.out.println("Student List:");
        for (StudentData student : students.values()) {
            System.out.println("Name: " + student.name + "\n Roll Number: " + student.rollNumber +
            		"\n Marks: " + student.marks  + "\n Percentage: " + student.percentage + "\n Grade: " + student.grade);
        }
    }
}

public class Student {
    public static void main(String[] args) {
        GradeManagementSystem gradeManagementSystem = new GradeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Example usage:
        Map<String, Integer> studentMarks = new HashMap<>();
        studentMarks.put("Math", 90);
        studentMarks.put("English", 85);
        studentMarks.put("Science", 78);

        //Add student
        
        StudentData student1 = new StudentData("Jerimy Gojar", 101, studentMarks);
        gradeManagementSystem.addStudent(student1);
        StudentData student2 = new StudentData("Ravi kumar", 102, studentMarks);
        gradeManagementSystem.addStudent(student2);

        StudentData student3 = new StudentData("Sunny Nikam", 103, studentMarks);
        gradeManagementSystem.addStudent(student3);

        StudentData student4 = new StudentData("Rishikesh", 104, studentMarks);
        gradeManagementSystem.addStudent(student4);

  
        // Print information about the added student
        gradeManagementSystem.printStudentList();
        
 /*       
        // Delete a student based on roll number
        int rollNumberToDelete = 101;
        gradeManagementSystem.deleteStudent(rollNumberToDelete);
        

//         Print updated student list after deletion
        gradeManagementSystem.printStudentList();
        
   */     
        
     // Update student's marks
/*
        System.out.println("Enter new marks for Math:");
        int newMathMarks = scanner.nextInt();
        System.out.println("Enter new marks for English:");
        int newEnglishMarks = scanner.nextInt();
        System.out.println("Enter new marks for Science:");
        int newScienceMarks = scanner.nextInt();

        Map<String, Integer> newMarks = new HashMap<>();
        newMarks.put("Math", newMathMarks);
        newMarks.put("English", newEnglishMarks);
        newMarks.put("Science", newScienceMarks);

        gradeManagementSystem.updateStudent(101, newMarks);
        

        // Print information about the added student
        gradeManagementSystem.printStudentList();
 */
        // Close the scanner
        scanner.close();
    }
}
