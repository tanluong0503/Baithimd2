package Bai_2.model;

public class Student {
    private long code;
    private String fullName;
    private int age;
    private String gender;
    private String address;
    private double mediumScore;

    public Student() {
    }

    public Student(String fullName, int age, String gender, String address, double mediumScore) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mediumScore = mediumScore;
    }

    public static Student parse(String line) {
        Student student = new Student();
        String[] fields = line.split(",");
        student.code = Long.parseLong(fields[0]);
        student.fullName = fields[1];
        student.age = Integer.parseInt(fields[2]);
        student.gender = fields[3];
        student.address = fields[4];
        student.mediumScore = Double.parseDouble(fields[5]);
        return student;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return code + "," +
                fullName + "," +
                age + "," +
                gender + "," +
                address + "," +
                mediumScore;
    }
}

