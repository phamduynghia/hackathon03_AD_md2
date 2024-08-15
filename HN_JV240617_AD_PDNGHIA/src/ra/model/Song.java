package ra.model;

import ra.service.SingerService;
import ra.service.SongService;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId, songName, description, songWriter;
    private Singer singer;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
    }

    public Song(String songId, String songName, String description, String songWriter, Singer singer, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.description = description;
        this.songWriter = songWriter;
        this.singer = singer;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    //    INPUT DATA
    public void inputData(Scanner scanner) {
        if (SingerService.indexSinger == 0) {
            System.err.println("Danh sách ca sĩ đang trống, bạn nên thêm ca sĩ trước.");
            return;
        }
        System.out.println("Nhập Id bài hát: ");
        this.songId = SongService.inputSongId(scanner.nextLine(), scanner);
        System.out.println("Nhập tên bài hát: ");
        this.songName = SongService.inputSongName(scanner.nextLine(), scanner);
        System.out.println("Nhập mô tả: ");
        this.description = scanner.nextLine();
        this.singer = SongService.inputSinger(scanner);
        System.out.println("Nhập nhạc sĩ: ");
        this.songWriter = SongService.inputSongWriter(scanner);
        this.createdDate = new Date();
        this.songStatus = SongService.inputSongStatus( scanner);
    }

    //    UPDATE DATA
    public void updateData(Scanner scanner) {
        System.out.println("Nhập tên bài hát");
        this.songName = SongService.inputSongName(scanner.nextLine(), scanner);
        System.out.println("Nhập mô tả: ");
        this.description = scanner.nextLine();
        this.singer = SongService.inputSinger(scanner);
        System.out.println("Nhập nhạc sĩ: ");
        this.songWriter = SongService.inputSongWriter(scanner);
        this.createdDate = new Date();
        this.songStatus = SongService.inputSongStatus(scanner);
    }

    //    DISPLAY DATA
    public void displayData() {
        System.out.printf("ID : %3s | Tên: %5s | Mô Tả: %5s | Nhạc sĩ %3s | Ca sĩ: %5s | Ngày tạo: %5s | Trạng thái: %3s\n",
                this.songId, this.songName, this.description, this.songWriter, this.singer.getSingerName(), this.createdDate, this.songStatus ? "Active" : "inActive");
    }
}
