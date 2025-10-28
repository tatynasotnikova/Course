import java.util.ArrayList;
import java.util.Set;

public class StudentUtils {


    public ArrayList<Student> removeStudents(ArrayList<Student> students) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student st : students) {
            if (st.grades >= 3) {
                result.add(st);
            }
        }
        return result;
    }

    public ArrayList<Student> addCourseStudents(ArrayList<Student> students) {
        ArrayList<Student> result = new ArrayList<>();
        for(Student st: students) {
            if(st.grades >= 3) {
                st.course += 1;
                result.add(st);
            }
        }
        return result;
    }

    public void printStudents(Set<Student> students, int course) {
        for(Student st: students) {
            if(st.course == course) {
                System.out.println(st.name);
            }
        }
    }
}
