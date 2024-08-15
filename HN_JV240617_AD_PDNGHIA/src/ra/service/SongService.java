package ra.service;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SongService {
    public static Song[] songs = new Song[100];
    public static int indexSong = 0;

    public static Song findSongById(String id) {
        for (int i = 0; i < indexSong; i++) {
            if (songs[i].getSongId().equals(id)) {
                return songs[i];
            }
        }
        return null;
    }


    public static String inputSongId(String songId, Scanner scanner) {
        String songidRegex = "S\\w{3}";
        while (true) {
            if (Pattern.matches(songidRegex, songId)) {
                if (findSongById(songId) == null) {
                    return songId;
                } else {
                    System.err.println("Id đã tồn tại, hãy thử lại");
                }
            } else {
                System.err.println("ID phải bắt đầu bằng S và có ít nhất 3 ký tự, vui lòng thử lại");
            }
            System.out.println("Nhập ID bài hát: ");
            songId = scanner.nextLine();
        }
    }

    public static String inputSongName(String songName, Scanner scanner) {
        while (true) {
            if (songName.trim().isEmpty()) {
                System.err.println("tên bài hát không được để trống, vui lòng thử lại");
                System.out.println("Nhập tên bài hát");
                songName = scanner.nextLine();
            } else {
                return songName;
            }
        }
    }

    public static Singer inputSinger(Scanner scanner) {
        System.out.println("Danh sách ca sĩ bạn có thể chọn:");
        for (int i = 0; i < SingerService.indexSinger; i++) {
            System.out.println(SingerService.singers[i]);
        }
        System.out.println("Nhập ID ca sĩ: ");
        int singerId = Integer.parseInt(scanner.nextLine());
        while (true) {
            if (SingerService.findSingerById(singerId) == null) {
                System.err.println("Không tìm thấy ca sĩ có id " + singerId);
                System.out.println("Thêm ca sĩ vào ");
                singerId = Integer.parseInt(scanner.nextLine());
            } else {
                return SingerService.findSingerById(singerId);
            }
        }
    }

    public static String inputSongWriter(Scanner scanner) {
        System.out.println("Nhập nhạc sĩ: ");
        while (true) {
            String songWriter = scanner.nextLine();
            if (songWriter.trim().isEmpty()) {
                System.err.println("người viết bài hát không được để trống, vui lòng thử lại.");
            } else {
                return songWriter;
            }
        }
    }

    public static boolean inputSongStatus(Scanner scanner) {
        System.out.println("Nhập Trạng thái Bài hát(true/false): ");
        while (true) {
            String songStatus = scanner.nextLine().toLowerCase();
            if (songStatus.equals("true") || songStatus.equals("talse")) {
                return Boolean.parseBoolean(songStatus);
            } else {
                System.err.println("Cú pháp của bạn sai, hãy thử lại.");
            }
            System.out.println("Nhập Trạng thái Bài hát(true/false): ");
        }
    }

    //   thêm bài hát
    public static void addSong(Scanner scanner) {
        System.out.println("Nhập số lượng bài hát bạn cần thêm: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Thêm bài hát " + (i + 1));
            Song song = new Song();
            song.inputData(scanner);
            songs[indexSong] = song;
            indexSong++;
        }
        System.out.println("Thêm " + number + " bài hát thành công.");
    }

    //   hiển thị danh sách bài hát
    public static void listSong() {
        if (indexSong == 0) {
            System.err.println("Danh sách bài hát đang trống.");
            return;
        }
        System.out.println("**********************************LIST SONGS*************************************");
        for (int i = 0; i < indexSong; i++) {
            songs[i].displayData();
        }
    }

    //   thay đổi thông tin theo id
    public static void updateSong(Scanner scanner) {
        System.out.println("Nhập ID bạn muốn cập nhật: ");
        String id = scanner.nextLine();
        if (findSongById(id) == null) {
            System.err.println("Không tìm thấy bài hát. ");
            return;
        }
        System.out.println("Thông tin bài hát.");
        findSongById(id).displayData();
        System.out.println("Nhập thông tin mới cho bài hát này: ");
        findSongById(id).updateData(scanner);
        System.out.println("Cập nhật bài hát thành công.");
    }

    //   xóa bài hát theo id
    public static void deleteSong(Scanner scanner) {
        while (true) {
            System.out.println("Nhập Id bài hát bạn muốn xóa: ");
            String id = scanner.nextLine();
            int indexDelete = -1;
            for (int i = 0; i < indexSong; i++) {
                if (songs[i].getSongId().equals(id)) {
                    indexDelete = i;
                    break;
                }
            }
            if (indexDelete == -1) {
                System.err.println("Bài hát không tìm thấy.");
            } else {
                for (int i = indexDelete; i < indexSong; i++) {
                    songs[i] = songs[i + 1];
                }
                System.out.println("Xóa bài hát thành công.");
                indexSong--;
                break;
            }
        }
    }
}
