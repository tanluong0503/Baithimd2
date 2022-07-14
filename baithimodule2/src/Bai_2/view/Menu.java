package Bai_2.view;

import Bai_2.utils.AppUtils;

public class Menu {
    public static void run() {
        StudentView studentView = new StudentView();
        System.out.println();
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách sinh viên");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Thoát");
        int choose = AppUtils.retryChoose(1, 8);
        switch (choose) {
            case 1:
                studentView.showStudentList();
                break;
            case 2:
                studentView.addStudent();
                break;
            case 3:
                studentView.updateStudent();
                break;
            case 4:
                studentView.removeStudent();
                break;
            case 5:
                sort();
                break;
            case 6:
                AppUtils.exit();
                break;
        }
    }

    public static void sort() {
        StudentView studentView = new StudentView();
        System.out.println();
        System.out.println("---- Sắp xếp sinh viên theo điểm trung bình ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Sắp xếp điểm trung bình tăng dần");
        System.out.println("2. Sắp xếp điểm trung bình tăng giảm dần");
        System.out.println("3. Thoát");
        int choice = AppUtils.retryChoose(1, 3);
        switch (choice) {
            case 1:
                studentView.sortStudentByScoreADC();
                break;
            case 2:
                studentView.sortStudentByScoreDEC();
                break;
            case 3:
                run();
                break;
        }
    }
}
