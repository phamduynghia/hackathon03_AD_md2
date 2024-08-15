package ra.controller;

import ra.service.SongService;
import ra.run.MusicManagement;

import java.util.Scanner;

public class SongController {
    public static void menuSongManagement(Scanner scanner) {
        boolean flag = true;
        while (flag) {
            System.out.println("**************************SONG-MANAGEMENT*****************************");
            System.out.printf("| %70s"," | \n");
            System.out.printf("| %-66s |%n","     1.        Thêm bài hát mới.");
            System.out.printf("| %-66s |%n","     2.        Hiển thị thông tin bài hát.");
            System.out.printf("| %-66s |%n","     3.        Thay đôi cập nhập thông tin bài hát.");
            System.out.printf("| %-66s |%n","     4.        Xóa bài hát theo Id.");
            System.out.printf("| %-66s |%n","     5.        Thoát.");
            System.out.printf("| %70s"," | \n");
            System.out.println("**********************************************************************");
            System.out.println("Chọn chức năng: ");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    SongService.addSong(scanner);
                    break;
                case 2:
                    SongService.listSong();
                    break;
                case 3:
                    SongService.updateSong(scanner);
                    break;
                case 4:
                    SongService.deleteSong(scanner);
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
