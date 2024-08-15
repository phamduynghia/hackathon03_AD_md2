package ra.run;

import ra.controller.SearchController;
import ra.controller.SingerController;
import ra.controller.SongController;

import java.util.Scanner;

public class MusicManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("**************************MUSIC-MANAGEMENT****************************");
            System.out.printf("| %70s", " | \n");
            System.out.printf("| %-66s |%n", "     1.            Quản lý ca sĩ.");
            System.out.printf("| %-66s |%n", "     2.            Quản lý bài hát.");
            System.out.printf("| %-66s |%n", "     3.            Tìm kiếm bài hát.");
            System.out.printf("| %-66s |%n", "     4.            Thoát.");
            System.out.printf("| %70s", " | \n");
            System.out.println("**********************************************************************");
            System.out.println("Chọn chức năng: ");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    SingerController.showSingerMenu(scanner);
                    break;
                case 2:
                    SongController.menuSongManagement(scanner);
                    break;
                case 3:
                    SearchController.searchManagement(scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ, vui lòng thử lại.");
            }
        }
    }
}
