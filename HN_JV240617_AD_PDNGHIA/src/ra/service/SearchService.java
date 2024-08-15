package ra.service;

import ra.model.Singer;

import java.util.Scanner;

public class SearchService {
//    .Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại
    public static void searchSong(Scanner scanner){
        if(SongService.indexSong == 0){
            System.err.println("Danh sách bài hát đang trống, hãy thêm bài hát trước.");
            return;
        }
        if(SingerService.indexSinger == 0){
            System.err.println("Danh sách ca sĩ đang trống, hãy thêm ca sĩ trước.");
            return;
        }
        System.out.println("Nhập tên bài hát hoặc thể loại: ");
        String search = scanner.nextLine();
        int count = 0;
        for(int i = 0; i< SongService.indexSong;i++){
            if(SongService.songs[i].getSinger().getSingerName().contains(search) || SongService.songs[i].getSinger().getGenre().contains(search)){
                SongService.songs[i].displayData();
                count++;
            }
        }
        if(count == 0){
            System.err.println("Không tìm thấy bài hát nào.");
        }else {
            System.out.println("Tìm thấy " + count + " bài hát");
        }
    }


//    Tìm kiếm ca sĩ theo tên hoặc thể loại
    public static void searchSinger(Scanner scanner){
        if(SingerService.indexSinger == 0){
            System.err.println("Danh sách ca sĩ đang trống, hãy thêm bài hát trước.");
            return;
        }
        System.out.println("Nhập tên ca sĩ hoặc thể loại nhạc: ");
        String search = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < SingerService.indexSinger;i++){
            if(SingerService.singers[i].getSingerName().contains(search) || SingerService.singers[i].getGenre().contains(search)){
                SingerService.singers[i].displayData();
                count++;
            }
        }
        if(count == 0){
            System.err.println("Không tìm thấy ca sĩ nào.");
        }else{
            System.out.println("Tìm thấy " + count + " ca sĩ");
        }
    }

//    hiển thị danh sách bài hát
    public static void sortSingerByName() {
        for (int i = 0; i < SingerService.indexSinger - 1; i++) {
            for (int j = 0; j < SingerService.indexSinger - i - 1; j++) {
                if (SingerService.singers[j].getSingerName() != null && SingerService.singers[j + 1].getSingerName() != null) {
                    if (SingerService.singers[j].getSingerName().compareTo(SingerService.singers[j + 1].getSingerName()) > 0) {
                        Singer temp = SingerService.singers[j];
                        SingerService.singers[j] = SingerService.singers[j + 1];
                        SingerService.singers[j + 1] = temp;
                    }
                }
            }
        }
    }

//    Hiển thị 10 bài hát
    public static void displayTenSongsSoon(){
        if(SongService.indexSong < 10){
            System.err.println("Danh sách bài hát phải lớn hơn 10.");
            return;
        }
        int count = 0;
        for(int i = SongService.indexSong-1; count <= 10 ;i--){
            System.out.println("Bài: "+(count+1));
            SongService.songs[i].displayData();
            count++;
        }
    }
}
