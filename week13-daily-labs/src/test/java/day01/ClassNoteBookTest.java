package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    @Test
    void addStudent() {
        ClassNoteBook classNoteBook =new ClassNoteBook();

        Student s1 =new Student(1,"Zoltán");
        classNoteBook.addStudent(s1);
        assertEquals(0,classNoteBook.getNotebook().get(s1).size());
    }

    @Test
    void addMark() {
        ClassNoteBook classNoteBook =new ClassNoteBook();

        Student s1 =new Student(1,"Zoltán");
        Student s2 =new Student(4,"László");
        Student s3 =new Student(3,"Kriszti");

        classNoteBook.addStudent(s1);
        classNoteBook.addStudent(s2);
        classNoteBook.addStudent(s3);

        classNoteBook.addMark(4,5);
        assertEquals(5,classNoteBook.getNotebook().get(s2).get(0));

    }
}