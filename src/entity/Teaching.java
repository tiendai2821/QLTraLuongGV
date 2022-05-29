package entity;

import java.util.Arrays;

public class Teaching {

    private Teacher teacher;
    private Subject[] subjects;
    private int[] tongSoLopMaGvDay;
    private int tongSoTiet;

    public Teaching(){

    }


    public Teaching(Teacher teacher, Subject[] subjects, int[] tongSoLopMaGvDay,int tongSoTiet) {
        this.teacher = teacher;
        this.subjects = subjects;
        this.tongSoLopMaGvDay = tongSoLopMaGvDay;
        this.tongSoTiet = tongSoTiet;
    }



    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public int[] getTongSoLopMaGvDay() {
        return tongSoLopMaGvDay;
    }

    public void setTongSoLopMaGvDay(int[] tongSoLopMaGvDay) {
        this.tongSoLopMaGvDay = tongSoLopMaGvDay;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {

        this.tongSoTiet = tongSoTiet;
    }

    @Override
    public String toString() {
        return "Teaching{" +
                "Teacher: " + teacher +
                ", Các môn dạy: " + Arrays.toString(subjects) +
                ", với lần lượt số lớp là=" + Arrays.toString(tongSoLopMaGvDay) +
                '}';
    }
}
