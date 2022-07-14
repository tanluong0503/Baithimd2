package Bai_2.view;

import Bai_2.model.Student;
import Bai_2.services.StudentServices;
import Bai_2.utils.AppUtils;
import Bai_2.utils.InputOption;
import Bai_2.utils.Validate;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    StudentServices studentServices = new StudentServices();
    Scanner scanner = new Scanner(System.in);

    public StudentView() {
    }

    public void addStudent() {
        do {
            System.out.println("---- THÊM SINH VIÊN MỚI ----");
            String name = inputFullName();
            int age = inputAge();
            String gender = inputGender();
            String address = inputAddress();
            double mediumScore = inputMediumScore();
            Student student = new Student(name, age, gender, address, mediumScore);
            studentServices.add(student);
            System.out.println("++++ ĐÃ THÊM THÀNH CÔNG ++++");
            System.out.println();
            AppUtils.isRetry(InputOption.ADD);
        } while (true);
    }

    public void updateStudent() {
        do {
            System.out.println("---- CHỈNH SỬA THÔNG TIN SINH VIÊN ----");
            long code;
            do {
                System.out.print("Nhập mã sinh viên cần chỉnh sửa: ");
                code = inputCode();
                if (!studentServices.existsCode(code)) {
                    System.out.println("Không tìm được sinh viên với mã sinh viên trên!");
                    System.out.println();
                    AppUtils.isRetry(InputOption.UPDATE);
                }
            } while (!studentServices.existsCode(code));
            Student afterStudent = new Student();
            afterStudent.setCode(code);
            Student student = studentServices.getByCode(code);

            System.out.println("Tên hiện tại: " + student.getFullName());
            String newName = inputFullName();
            afterStudent.setFullName(newName);
            System.out.println("Tuổi hiện tại: " + student.getAge());
            int newAge = inputAge();
            afterStudent.setAge(newAge);
            System.out.println("Giới tính hiện tại: " + student.getGender());
            String newGender = inputGender();
            afterStudent.setGender(newGender);
            System.out.println("Địa chỉ hiện tại: " + student.getAddress());
            String newAddress = inputAddress();
            afterStudent.setAddress(newAddress);
            System.out.println("Điểm TB hiện tại: " + student.getMediumScore());
            double newScore = inputMediumScore();
            afterStudent.setMediumScore(newScore);
            studentServices.edit(afterStudent);
            System.out.println("✍✍✍✍ ĐÃ CHỈNH SỬA THÀNH CÔNG ✍✍✍✍");
            System.out.println();
            AppUtils.isRetry(InputOption.UPDATE);
        } while (true);
    }

    public void removeStudent() {
        do {

            System.out.println("---- XÓA SINH VIÊN ----");
            long code;
            do {
                System.out.print("Nhập mã sinh viên cần xóa: ");
                code = inputCode();
                if (!studentServices.existsCode(code)) {
                    System.out.println("Không tìm được sinh viên với mã sinh viên trên!");
                    AppUtils.isRetry(InputOption.REMOVE);
                }
            } while (!studentServices.existsCode(code));
            System.out.println("Thông tin sinh viên muốn xóa:");
            Student student = studentServices.getByCode(code);
            System.out.println("Mã SV: " + student.getCode());
            System.out.println("Tên: " + student.getFullName());
            System.out.println("Tuổi: " + student.getAge());
            System.out.println("Giới tính: " + student.getGender());
            System.out.println("Địa chỉ: " + student.getAddress());
            System.out.println("Điểm TB: " + student.getMediumScore());
            System.out.println();
            System.out.println("╒═════BẠN CÓ CHẮC MUỐN XÓA═════╕");
            System.out.println("│                              │");
            System.out.println("│        ▫ 1. Xác nhận         │");
            System.out.println("│        ▪ 2. Hủy bỏ           │");
            System.out.println("│                              │");
            System.out.println("╘═════════◦◦◦◦◦◦◦◦◦◦◦◦═════════╛");
            int option = AppUtils.retryChoose(1, 2);
            if (option == 1) {
                studentServices.removeByCode(code);
                System.out.println("✘✘✘✘ ĐÃ XÓA THÀNH CÔNG ✘✘✘✘");
                System.out.println();
                AppUtils.isRetry(InputOption.REMOVE);
            } else if (option == 2) {
                AppUtils.isRetry(InputOption.REMOVE);
            }
        } while (true);
    }

    public void sortStudentByScoreADC() {
        do {
            List<Student> studentList = studentServices.findAll();
            List<Student> sortList = studentServices.sortAgeADC(studentList);
            System.out.println("______________________________ DANH SÁCH SINH VIÊN THEO ĐIỂM TRUNG BÌNH _____________________________");
            System.out.println("_______________________________________________ GIẢM DẦN ____________________________________________");
            System.out.printf("\t%-5s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                    "STT", "Mã Học Viên", "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm TB");
            int i = 1;
            for (Student student : sortList) {
                System.out.printf("\t%-5d%-20d%-20s%-20d%-20s%-20s%-20.1f\n",
                        i, student.getCode(),
                        student.getFullName(),
                        student.getAge(),
                        student.getGender(),
                        student.getAddress(),
                        student.getMediumScore()
                );
                i++;
            }
            System.out.println();
            AppUtils.isRetry(InputOption.SHOW);
        } while (true);
    }

    public void sortStudentByScoreDEC() {
        do {
            List<Student> studentList = studentServices.findAll();
            List<Student> sorfList = studentServices.sortAgeDEC(studentList);
            System.out.println("______________________________ DANH SÁCH SINH VIÊN THEO ĐIỂM TRUNG BÌNH _____________________________");
            System.out.println("_______________________________________________ GIẢM DẦN ____________________________________________");
            System.out.printf("\t%-5s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                    "STT", "Mã Học Viên", "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm TB");
            int i = 1;
            for (Student student : sorfList) {
                System.out.printf("\t%-5d%-20d%-20s%-20d%-20s%-20s%-20.1f\n",
                        i, student.getCode(),
                        student.getFullName(),
                        student.getAge(),
                        student.getGender(),
                        student.getAddress(),
                        student.getMediumScore()
                );
                i++;
            }
            System.out.println();
            AppUtils.isRetry(InputOption.SHOW);
        } while (true);
    }

    public void showStudentList() {
        do {
            System.out.println("__________________________________________________ DANH SÁCH SINH VIÊN __________________________________________________");
            List<Student> studentList = studentServices.findAll();
            System.out.printf("\t%-5s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                    "STT", "Mã Học Viên", "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm TB");
            int i = 1;
            for (Student student : studentList) {
                System.out.printf("\t%-5d%-20d%-20s%-20d%-20s%-20s%-20.1f\n",
                        i, student.getCode(),
                        student.getFullName(),
                        student.getAge(),
                        student.getGender(),
                        student.getAddress(),
                        student.getMediumScore()
                );
                i++;
            }
            AppUtils.isRetry(InputOption.SHOW);
        } while (true);
    }

    public String inputFullName() {
        System.out.print("Nhập họ và tên (VD: Nguyen Tan Luong): ");
        String fullName;
        do {
            if (!Validate.fullNameValid(fullName = AppUtils.retryString("Họ và tên"))) {
                System.out.print(fullName + " không đúng, hãy nhập lại (VD: Nguyen Tan Luong): ");
                continue;
            }
            break;
        } while (true);
        return fullName;
    }

    private int inputAge() {
        int age;
        System.out.print("❒ Nhập tuổi: ");
        do {
            age = AppUtils.retryParseInt();
            if (age <= 0)
                System.out.print("Số tuổi phải lớn hơn 0, hãy nhập lại: ");
            if (age > 60)
                System.out.print("Không vượt quá 60 tuổi: ");
        } while (age <= 0 || age > 60);
        return age;
    }

    public String inputGender() {
        System.out.print("Nhập giới tính (Nam | Nữ | Khác): ");
        String gender;
        do {
            if (!Validate.genderValid(gender = AppUtils.retryString("Giới tính"))) {
                System.out.print(gender + " không đúng, hãy nhập lại (Nam | Nữ | Khác): ");
                continue;
            }
            break;
        } while (true);
        return gender;
    }

    public String inputAddress() {
        System.out.print("Nhập địa chỉ (gồm chữ hoặc số hoặc dấu ','): ");
        String address;
        do {
            if (!Validate.addressValid(address = AppUtils.retryString("Địa chỉ"))) {
                System.out.print(address + " không đúng, hãy nhập lại (gồm chữ hoặc số hoặc dấu ','): ");
                continue;
            }
            break;
        } while (true);
        return address;
    }

    private double inputMediumScore() {
        double mediumScore;
        System.out.print("❒ Nhập điểm trung bình: ");
        do {
            mediumScore = AppUtils.retryParseDoble();
            if (mediumScore <= 0.0)
                System.out.print("Điểm TB phải lớn hơn 0, hãy nhập lại: ");
            if (mediumScore > 10.0)
                System.out.print("Không vượt quá 10 điểm: ");
        } while (mediumScore <= 0.0 || mediumScore > 10.0);
        return mediumScore;
    }

    public long inputCode() {
        long code;
        do {
            code = AppUtils.retryParseLong();
            if (code <= 0)
                System.out.print("Nhập sai, hãy nhập lại: ");
        } while (code <= 0);
        return code;
    }
}











