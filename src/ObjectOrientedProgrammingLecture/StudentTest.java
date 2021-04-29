package ObjectOrientedProgrammingLecture;

public class StudentTest {

    public static void main(String[] args) {
        Student kenneth = new Student("Kenneth Howell", "Deimos", 80);

        System.out.println("kenneth.name = " + kenneth.name);
        System.out.println("kenneth.cohort = " + kenneth.cohort);
//        System.out.println("kenneth.grade = " + kenneth.grade); // don't do this
        System.out.println("kenneth.shareGrade() = " + kenneth.shareGrade());
    }
}
