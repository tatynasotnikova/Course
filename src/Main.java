import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Иван Иванов", 101, 1, 4);
        Student student2 = new Student("Петр Петров", 101, 1, 2);
        Student student3 = new Student("Мария Сидорова", 102, 2, 5);
        Student student4 = new Student("Анна Козлова", 102, 2, 3);
        Student student5 = new Student("Сергей Смирнов", 103, 1, 1);

        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);

        System.out.println("Исходный список студентов:");
        printStudentList(studentsList);

        StudentUtils utils = new StudentUtils();
        ArrayList<Student> filteredStudents = utils.removeStudents(new ArrayList<>(studentsList));
        System.out.println("После удаления студентов с оценкой < 3:");
        printStudentList(filteredStudents);

        ArrayList<Student> promotedStudents = utils.addCourseStudents(new ArrayList<>(studentsList));
        System.out.println("После перевода на следующий курс:");
        printStudentList(promotedStudents);

        Set<Student> studentSet = new HashSet<>(studentsList);
        System.out.println("Студенты 1 курса:");
        utils.printStudents(studentSet, 1);
        System.out.println("Студенты 2 курса:");
        utils.printStudents(studentSet, 2);

        PhoneDirectory directory = new PhoneDirectory();

        directory.add("Иван Иванов", "+7-123-456-78-90");
        directory.add("Иван Иванов", "+7-123-456-78-91");
        directory.add("Петр Петров", "+7-987-654-32-10");
        directory.add("Мария Сидорова", "+7-111-222-33-44");

        System.out.println("Номера Ивана Иванова: " + directory.get("Иван Иванов"));
        System.out.println("Номера Петра Петрова: " + directory.get("Петр Петров"));
        System.out.println("Номера Несуществующий: " + directory.get("Несуществующий"));
    }

    public static void printStudentList(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(" Имя: " + student.name + " Группа: " + student.group +" Курс: " + student.course + " Оценка: " + student.grades);
        }
    }
}