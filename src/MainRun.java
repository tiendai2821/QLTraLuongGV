import entity.Subject;

import java.util.Scanner;

public class MainRun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Management management = new Management();

        while (true) {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    management.createSubject();

                    break;
                case 2:
                    management.showInfoSubject();
//
                    break;
                case 3:
                    management.createTeacher();
                    break;
                case 4:
                    management.showInfoTeacher();
                    break;
                case 5:
                    management.management();
                    management.showManagement();
                    break;

                case 6:
                  management.sortByName();
                  management.showManagement();
                    break;
                case 7:
                  management.sortByLessionNum();
                  management.showManagement();
                    break;
                case 8:
                    management.tinhLuong();
                    break;
                case 9:
                    System.out.println("Thanks for use my system");
                    return;
            }


        }
    }
    private static int functionChoice() {
        System.out.println("\n\n===== PHẦN MỀM QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN THỈNH GIẢNG =====\n\n");
        System.out.println("1. Nhập danh sách môn học mới.");
        System.out.println("2. In ra danh sách môn học trong hệ thống.");
        System.out.println("3. Nhập danh sách giảng viên.");
        System.out.println("4. In ra danh sách giảng viên trong hệ thống.");
        System.out.println("5. Lập bảng kê khai giảng dạy cho mỗi giảng viên.");
        System.out.println("6. Sắp xếp danh sách kê khai giảng dạy theo tên giảng viên");
        System.out.println("7. Sắp xếp danh sách kê khai giảng dạy theo số tiết giảng dạy mỗi môn giảm dần");
        System.out.println("8. In ra bảng tính tính tiền công cho giảng viên");
        System.out.println("9. Thoát chương trình");
        System.out.println("--------------------------------------");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 9) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: ");
        } while (functionChoice > 9 || functionChoice < 1);
        return functionChoice;
    }

}
