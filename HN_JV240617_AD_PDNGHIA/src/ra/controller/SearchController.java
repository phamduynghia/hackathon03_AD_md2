package ra.controller;

import ra.service.SearchService;

import java.util.Scanner;

public class SearchController {
    public static void searchManagement(Scanner scanner){
        boolean flag = true;
        while (flag) {
            System.out.println("*************************SEARCH-MANAGEMENT****************************");
            System.out.printf("| %70s"," | \n");
            System.out.printf("| %-66s |%n","     1.        Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại.");
            System.out.printf("| %-66s |%n","     2.        Tìm kiếm ca sĩ theo tên hoặc thể loại.");
            System.out.printf("| %-66s |%n","     3.        Hiển thị danh sách bài hát theo thứ tự tên tăng dần.");
            System.out.printf("| %-66s |%n","     4.        Hiển thị 10 bài hát được đăng mới nhất.");
            System.out.printf("| %-66s |%n","     5.        Thoát.");
            System.out.printf("| %70s"," | \n");
            System.out.println("**********************************************************************");
            System.out.println("Chọn chức năng: ");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    SearchService.searchSong(scanner);
                    break;
                case 2:
                    SearchService.searchSinger(scanner);
                    break;
                case 3:
                    SearchService.sortSingerByName();
                    break;
                case 4:
                    SearchService.displayTenSongsSoon();
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
