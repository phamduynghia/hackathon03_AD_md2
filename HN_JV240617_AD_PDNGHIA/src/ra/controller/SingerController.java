package ra.controller;

import ra.service.SingerService;

import java.util.Scanner;

public class SingerController {
    public static void showSingerMenu(Scanner scanner){
        boolean flag = true;
        while (flag) {
            System.out.println("*************************SINGER-MANAGEMENT****************************");
            System.out.printf("| %70s"," | \n");
            System.out.printf("| %-66s |%n","     1.        Thêm ca sĩ mới.");
            System.out.printf("| %-66s |%n","     2.        Danh sách ca sĩ.");
            System.out.printf("| %-66s |%n","     3.        Thay đổi cập nhập ca sĩ.");
            System.out.printf("| %-66s |%n","     4.        Xóa ca sĩ.");
            System.out.printf("| %-66s |%n","     5.        Thoát.");
            System.out.printf("| %70s"," | \n");
            System.out.println("**********************************************************************");
            System.out.println("Chọn chức năng: ");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    SingerService.addSinger(scanner);
                    break;
                case 2:
                    SingerService.showListSinger();
                    break;
                case 3:
                    SingerService.updateSinger(scanner);
                    break;
                case 4:
                    SingerService.deleteSinger(scanner);
                    break;
                case 5:
                    flag = false;
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ, vui lòng thử lại.");
            }
        }
    }
}
