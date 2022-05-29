package entity;

import constant.Level;

import java.util.Scanner;

public class Teacher extends Person  {
    private int teacherId;
    private Level level;
    private float salary;

    private static int sId=100;

    public Teacher(){

    }

    public Teacher(int teacherId, Level level) {

        this.teacherId = sId++;
        this.level = level;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void inputInfo(){
        this.teacherId = sId++;
        super.inputInfo();
        System.out.print("\n Nhập trình độ: \n 1: là GS-TS \n 2: là PGS-TS \n 3: là GIANGVIENCHINH \n 4: là THACSI");
        int nhapLevel = new Scanner(System.in).nextInt();
        do {
            switch (nhapLevel) {
                case 1:
                    level = Level.GSTS;
                    break;
                case 2:
                    level = Level.PGSTS;
                    break;
                case 3:
                    level = Level.GIANGVIENCHINH;
                    break;
                case 4:
                    level = Level.THACSI;
                    break;
            }
        }while (nhapLevel < 0 && nhapLevel >4);

    }
    @Override
    public String toString() {
        super.toString();
        return "Teacher{" +
                "id=" + teacherId +
                " name=" +name+
                ", address="+address+
                ", phone=" +phoneNum+
                ", level='" + level + '\'' +
                '}';
    }



}
