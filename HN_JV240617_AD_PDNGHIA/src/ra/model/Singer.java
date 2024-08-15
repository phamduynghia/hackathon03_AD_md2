package ra.model;

import ra.service.SingerService;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private String genre;
    private boolean gender;

    public Singer() {
    }

    public Singer(String singerName, int age, String nationality, String genre, boolean gender) {
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.genre = genre;
        this.gender = gender;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    //    INPUT DATA
    public void inputData(Scanner sc) {
        this.singerId = SingerService.inputSingerId();

        this.singerName = SingerService.inputSingerName( sc);

        this.age = SingerService.inputAge( sc);

        this.nationality = SingerService.inputNationality( sc);

        this.gender = SingerService.inputGender( sc);

        this.genre = SingerService.inputGenre(sc);
    }

    //       UPDATE DATA
    public void updateData(Scanner sc) {

        this.singerName = SingerService.inputSingerName( sc);

        this.age = SingerService.inputAge(sc);

        this.nationality = SingerService.inputNationality( sc);

        this.gender = SingerService.inputGender( sc);

        this.genre = SingerService.inputGenre( sc);
    }

    //        DISPLAY DATA
    public void displayData() {
        System.out.printf("ID : %3s | Tên: %5s | Tuổi: %3s | Thể loại: %5s | Giới tính: %3s | Quốc tịch: %3s \n",
                this.singerId, this.singerName, this.age, this.genre, this.gender ? "Nam" : "Nữ", this.nationality);
    }

    public String toString() {
        return String.format("ID : %2s | Tên: %4s\n", this.singerId, this.singerName);
    }

}



