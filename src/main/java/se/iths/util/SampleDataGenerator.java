package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.*;

@Singleton
@Startup
public class SampleDataGenerator {
    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Geography");
        Subject subject3 = new Subject("History");

        Student student1 = new Student("Kalle","Anka","kalle.anka@gmail.com"
                ,"1234567");
        Student student2 = new Student("Sven","Svensson","sven.svensson@gmail.com"
                ,"7654321");
        Student student3 = new Student("Joe","Bravo","joe.bravo@gmail.com",
                "7651234");

        Teacher teacher1 = new Teacher("Albert","Einstein","albert.einstein@gmail.com",
                "1234765");
        Teacher teacher2 = new Teacher("Alan","Turing","alan.turing@gmail.com",
                "9871234");
        Teacher teacher3 = new Teacher("James","Gosling","james.gosling@gmail.com",
                "7894321");

        subject1.addTeacher(teacher1);
        subject1.addStudent(student1);
        subject1.addStudent(student2);

        subject2.addTeacher(teacher2);
        subject2.addStudent(student1);
        subject2.addStudent(student2);
        subject2.addStudent(student3);

        subject3.addTeacher(teacher3);
        subject3.addStudent(student1);
        subject3.addStudent(student2);

        subject1.addTeacher(teacher3);
        subject1.addStudent(student3);

        entityManager.persist(subject1);
        entityManager.persist(subject2);
        entityManager.persist(subject3);

    }
}