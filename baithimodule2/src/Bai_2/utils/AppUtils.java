package Bai_2.utils;

import Bai_2.view.Menu;

import java.util.Scanner;

public class AppUtils {
    public static int retryChoose(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.print("Chọn chức năng: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Chọn chức năng không đúng, hãy chọn lại: ");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Nhập sai, hãy nhập lại: ");
            }
        } while (true);
        return option;
    }

    public static String retryString(String field) {
        Scanner scanner = new Scanner(System.in);
        String result;
        while ((result = scanner.nextLine()).isEmpty()) {
            ;
            System.out.printf("%s không được để trống, hãy nhập lại: ", field);
        }
        return result;
    }

    public static int retryParseInt() {
        Scanner scanner = new Scanner(System.in);
        int result;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.print("Nhập sai! vui lòng nhập lại: ");
            }
        } while (true);
    }

    public static double retryParseDoble() {
        Scanner scanner = new Scanner(System.in);
        double result;
        do {
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.print("Nhập sai! vui lòng nhập lại: ");
            }
        } while (true);
    }

    public static long retryParseLong() {
        Scanner scanner = new Scanner(System.in);
        long result;
        do {
            try {
                result = Long.parseLong(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.print("Nhập sai, hãy nhập lại: ");
            }
        } while (true);
    }

    public static boolean isRetry(InputOption inputOption) {
        Scanner sc = new Scanner(System.in);
        do {
            switch (inputOption) {
                case ADD:
                    System.out.println("Nhấn 'n' để thêm tiếp \t|\t 'b' để quay lại \t|\t 'e' để thoát chương trình");
                    break;
                case UPDATE:
                    System.out.println("Nhấn 'n' để sửa tiếp \t|\t 'b' để quay lại\t|\t 'e' để thoát chương trình");
                    break;
                case REMOVE:
                    System.out.println("Nhấn 'n' để xóa tiếp \t|\t 'b' để quay lại\t|\t 'e' để thoát chương trình");
                    break;
                case SHOW:
                    System.out.println("Nhấn 'b' để quay lại\t|\t 'e' để thoát chương trình");
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + inputOption);
            }
            System.out.print(" Chọn ➤ ");
            String option = sc.nextLine();
            switch (option) {
                case "n":
                    return true;
                case "b":
                    Menu.run();
                    break;
                case "e":
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    break;
            }
        } while (true);
    }

    public static boolean exit() {
        System.out.println("╒════BẠN MUỐN ĐÓNG CHƯƠNG TRÌNH════╕");
        System.out.println("│                                  │");
        System.out.println("│          ▫ 1. Xác nhận           │");
        System.out.println("│          ▪ 2. Hủy bỏ             │");
        System.out.println("│                                  │");
        System.out.println("╘═══════════◦◦◦◦◦◦◦◦◦◦◦◦═══════════╛");
        int choose = AppUtils.retryChoose(1, 2);
        switch (choose) {
            case 1:
                System.out.println("---- Tạm biệt và hẹn gặp lại! ----");
                System.exit(0);
                break;
            case 2:
                return true;
        }
        return false;
    }
}
