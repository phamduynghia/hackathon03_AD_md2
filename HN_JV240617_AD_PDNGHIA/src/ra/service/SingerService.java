package ra.service;

import ra.model.Singer;

import java.util.Scanner;

public class SingerService {
    public static Singer[] singers = new Singer[100];
    public static int indexSinger = 0;

    public static Singer findSingerById(int id) {
        for (int i = 0; i < indexSinger; i++) {
            if (singers[i].getSingerId() == id) {
                return singers[i];
            }
        }
        return null;
    }

    public static int inputSingerId() {
        int idMax = 0;
        for (int i = 0; i < indexSinger; i++) {
            if (singers[i].getSingerId() > idMax) {
                idMax = singers[i].getSingerId();
            }
        }
        return idMax+1;
    }

    public static String inputSingerName( Scanner sc) {
        System.out.println("Nhập tên ca sĩ: ");
        while (true) {
            String singerName = sc.nextLine();
            if (singerName.trim().isEmpty()) {
                System.err.println("Tên ca sĩ không được để trống, vui lòng thử lại");
            } else {
                return singerName;
            }
        }
    }

    public static int inputAge(Scanner sc) {
        System.out.println("Nhập tuổi: ");
        while (true) {
            int age = Integer.parseInt(sc.nextLine());
            if (age <= 0) {

                System.err.println("Tuổi phải lớn hơn 0");


            } else {
                return age;
            }
        }
    }

    public static String inputNationality(Scanner sc) {
        System.out.println("Nhập quốc tịch: ");
        while (true) {
            String nationality = sc.nextLine();
            if (nationality.trim().isEmpty()) {
                System.err.println("Quốc tịch không được để trống, vui lòng thử lại.");
            } else {
                return nationality;
            }
        }
    }

    public static boolean inputGender( Scanner sc) {
        System.out.println("Nhập giới tính(Nam/Nữ): ");
        while (true) {
            String gender = sc.nextLine();
            if (gender.equals("Nam") || gender.equals("Nữ")) {
                return Boolean.parseBoolean(gender);
            } else {
                System.err.println("Nhập thông tin ca sĩ của bạn sai, hãy thử lại.");
            }
        }
    }

    public static String inputGenre(Scanner sc) {
        System.out.println("Nhập Thể loại: ");
        while (true) {
            String genre = sc.nextLine();
            if (genre.trim().isEmpty()) {
                System.err.println("Thể loại không được để trống, vui lòng thử lại.");
            } else {
                return genre;
            }
        }
    }


//    thêm ca sĩ
    public static void addSinger(Scanner sc) {
        System.out.println("Nhập ca sĩ bạn cần thêm: ");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin ca sĩ " + (i + 1));
            Singer singer = new Singer();
            singer.inputData(sc);
            singers[indexSinger] = singer;
            indexSinger++;
        }
        System.out.println("Thêm " + number + " ca sĩ thành công");
    }

//    hiển thị danh sách ca sĩ
    public static void showListSinger() {
        if (indexSinger == 0) {
            System.err.println("Danh sách ca sĩ đang trống.");
            return;
        }
        System.out.println("*********************************Thông tin ca sĩ***********************************");
        for (int i = 0; i < indexSinger; i++) {
            singers[i].displayData();
        }
    }

//    sửa cập nhập ca sĩ theo id
    public static void updateSinger(Scanner sc) {
        if (indexSinger == 0) {
            System.err.println("Danh sách ca sĩ đang trống.");
            return;
        }
        System.out.println("Nhập id ca sĩ bạn cần cập nhật: ");
        int singerId = Integer.parseInt(sc.nextLine());
        if (findSingerById(singerId) == null) {
            System.err.println("Không tìm thấy ca sĩ.");
        } else {
            findSingerById(singerId).updateData(sc);
        }
    }

//   xóa ca sĩ theo id
    public static void deleteSinger(Scanner scanner) {
        if (indexSinger == 0) {
            System.err.println("Danh sách ca sĩ đang trống.");
            return;
        }
        System.out.println("Nhập id ca sĩ bạn cần xóa: ");
        int singerId = Integer.parseInt(scanner.nextLine());
        if (findSingerById(singerId) != null) {
            for (int i = 0; i < SongService.indexSong; i++) {
                if (singerId == SongService.songs[i].getSinger().getSingerId()) {
                    System.err.println("Không thể xóa ca sĩ. ");
                    return;
                }
            }
            int indexDelete = -1;
            for (int i = 0; i < indexSinger; i++) {
                if (singers[i].getSingerId() == singerId) {
                    indexDelete = i;
                    break;
                }
            }
            for(int i = indexDelete; i < indexSinger; i++) {
                singers[i] = singers[i+1];
            }
            System.out.println("Xóa ca sĩ thành công.");
            indexSinger--;

        } else {
            System.err.println("Không tìm thấy ca sĩ.");
        }

    }
}
