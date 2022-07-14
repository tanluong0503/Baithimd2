package Bai_2.services;

import Bai_2.model.Student;
import Bai_2.utils.CSVUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StudentServices implements IStudentServices {
    public final static String PATH = "data\\student.csv";


    @Override
    public List<Student> findAll() {
        List<String> records = CSVUtils.read(PATH);
        List<Student> students = new ArrayList<>();
        for (String record : records) {
            students.add(Student.parse(record));
        }
        return students;
    }

    @Override
    public void add(Student newStudent) {
        long code = System.currentTimeMillis() / 1000;
        newStudent.setCode(code);
        List<Student> students = findAll();
        students.add(newStudent);
        CSVUtils.write(PATH, students);
    }

    @Override
    public void edit(Student afterStudent) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getCode() == afterStudent.getCode()) {
                String name = afterStudent.getFullName();
                if (name != null && !name.isEmpty()) {
                    student.setFullName(name);
                }
                int age = afterStudent.getAge();
                if (age != 0) {
                    student.setAge(age);
                }
                String gender = afterStudent.getGender();
                if (gender != null && !gender.isEmpty()) {
                    student.setGender(gender);
                }
                String address = afterStudent.getAddress();
                if (address != null && !address.isEmpty()) {
                    student.setAddress(gender);
                }
                double mediumScore = afterStudent.getMediumScore();
                if (mediumScore != 0.0) {
                    student.setMediumScore(mediumScore);
                }
                CSVUtils.write(PATH, students);
                break;
            }
        }

    }

    @Override
    public void removeByCode(long code) {
        List<Student> students = findAll();
        students.removeIf(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getCode() == code;
            }
        });
        CSVUtils.write(PATH, students);
    }

    @Override
    public boolean existsCode(long code) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Student getByCode(long code) {
        for (Student student : findAll()) {
            if (student.getCode() == code)
                return student;
        }
        return null;
    }

    @Override
    public List<Student> sortAgeADC(List<Student> studentList) {
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double result = o1.getMediumScore() - o2.getMediumScore();
                return result == 0 ? 0 : (result > 0 ? 1 : -1);
            }
        });
        return studentList;
    }

    @Override
    public List<Student> sortAgeDEC(List<Student> studentList) {
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double result = o2.getMediumScore() - o1.getMediumScore();
                return result == 0 ? 0 : (result > 0 ? 1 : -1);
            }
        });
        return studentList;
    }
}
