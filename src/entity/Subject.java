package entity;

import java.util.Scanner;

public class Subject {
    private int subjectId;
    private String subjectName;
    private int soTiet,soTietLyThuyet,mucKinhPhi;
    private static int id=100;

    public Subject(){}

    public Subject(String subjectName, int soTiet, int soTietLyThuyet, int mucKinhPhi) {
        this.subjectId = id++;
        this.subjectName= subjectName;
        this.soTiet = soTiet;
        this.soTietLyThuyet = soTietLyThuyet;
        this.mucKinhPhi = mucKinhPhi;
    }

    public void inputInfoSubject(){
        this.subjectId = id++;
        System.out.println("Nhập tên môn học thứ có id "+this.getSubjectId()+": ");
        this.subjectName = new Scanner(System.in).nextLine();
        boolean check = true;
        System.out.println("Nhập tổng số tiết học: ");
        do {
            this.soTiet = new Scanner(System.in).nextInt();
            if (this.soTiet <= 0) {
                System.out.println("Tổng số tiết lớn hơn 0! Nhập lại: ");
                check = false;
            }else{
                check = true;
            }
        } while (!check);
        System.out.println("Nhập số tiết lý thuyết: ");
        do {
            this.soTietLyThuyet = new Scanner(System.in).nextInt();
            if (this.soTietLyThuyet <= 0) {
                System.out.println("Số tiết lý thuyết lớn hơn 0! Nhập lại: ");
                check = false;
            }else {
                check = true;
            }
        } while (!check);
        System.out.println("Nhập mức kinh phí (lý thuyết): ");
        do {
            this.mucKinhPhi = new Scanner(System.in).nextInt();
            if (this.mucKinhPhi <= 0) {
                System.out.println("Mức kinh phí lớn hơn 0! Nhập lại: ");
                check = false;
            }else {
                check = true;
            }
        } while (!check);


    }




    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public int getMucKinhPhi() {
        return mucKinhPhi;
    }

    public void setMucKinhPhi(int mucKinhPhi) {
        this.mucKinhPhi = mucKinhPhi;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Subject.id = id;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName="+subjectName+
                ", tongSoTiet=" + soTiet +
                ", soTietLyThuyet=" + soTietLyThuyet +
                ", mucKinhPhi=" + mucKinhPhi +
                '}';
    }
}
