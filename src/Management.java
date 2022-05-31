import entity.Subject;
import entity.Teacher;
import entity.Teaching;
import service.ManagementService;

import java.util.Scanner;

public class Management implements ManagementService {

    int soLuongMh;
    int soLuongGv;

    public static Teacher[] teachers;
    public static Subject[] subjects;
    public static Teaching[] teachings;
    public static int teacherallnum = 0;
    public static int subjectallnum = 0;
    public static int teachingallnum = 0;
    static boolean check = true;

    @Override
    public void createTeacher() {
        System.out.println("Nhập số lượng gv: ");
        soLuongGv = new Scanner(System.in).nextInt();

        for(int i=0; i < soLuongGv;i++){
            Teacher teacher = new Teacher();
            teacher.inputInfo();
            teachers[teacherallnum] = teacher;
            teacherallnum ++;
        }
    }

    public void showInfoTeacher(){
        for(Teacher t:teachers){
            if(t!=null){
                System.out.println(t);
            }else {
                break;
            }
        }
    }

    @Override
    public void createSubject() {
        System.out.println("Nhập số lượng môn học: ");
        soLuongMh = new Scanner(System.in).nextInt();

        for(int i=0; i < soLuongMh;i++){
            Subject subject = new Subject();
            subject.inputInfoSubject();
            subjects[subjectallnum] = subject;
            subjectallnum++;
        }
    }

    public void showInfoSubject(){
        for(Subject s: subjects){
            if(s!= null){
                System.out.println(s);
            }
            else {
                break;
            }
        }
    }

    private static Subject getSubjectById(int subjectId) {
        for (Subject s : subjects) {
            if (s.getSubjectId() == subjectId) {
                return s;
            }
        }
        return null;
    }

    public static boolean checkExist(){
        return teachers[0] != null && subjects[0] != null;
    }
    public int searchTeacherById(int id){
        for(int i = 0; i< teacherallnum; i++){
            if(teachers[i].getTeacherId() == id){
                return id;
            }
        }
        return -1;
    }
    public int searchSubjectById(int id){
        for(int i = 0; i<2; i++){
            if(subjects[i].getSubjectId() == id){
                return id;
            }
        }
        return -1;
    }
    @Override
    public void management(){
        if(!checkExist()){
            System.out.println("Danh sách môn học hoặc gv rỗng");
            return;
        }

        System.out.println("Nhập số lượng giảng viên muốn kê khai");
        int n = new Scanner(System.in).nextInt();
        for (int i=1; i<=n;i++){
            System.out.println("Nhập id cho giảng viên thứ "+i+" :");
            int id;
            do{
                id = new Scanner(System.in).nextInt();
                id = searchTeacherById(id);

                if(id !=-1){
                    break;
                }
                System.out.println("Id giảng viên không tồn tại, mời nhập lại id cho giảng viên thứ "+ i);
            }while(true);


            System.out.println("Kê khai cho gv " + teachers[id-100].getName()+" có id "+ teachers[id-100].getTeacherId());
            System.out.println("Nhập số môn dạy của "+teachers[id-100].getName()+" có id "+teachers[id-100].getTeacherId());
            int soMon;
            do {
                soMon = new Scanner(System.in).nextInt();
                if(soMon <=0 || soMon > subjectallnum) check = true;
            } while (!check);
            check = true;
            Subject[] listMonGvDay = new Subject[soMon];      // list này chứa các môn mà gv trên dạy
            int[] totalClassArray = new int[soMon];

            int tongSoTietCuaGv = 0;
            int tongSoLopCuaMon;
            int subjectId;
            float salary = 0;
            for(int j=0;j<soMon;j++){
                int tongSoTietCua1mon= 0;
                System.out.print("Nhập id môn thứ " + (j + 1) + " mà giảng viên " + teachers[id-100].getName() + " dạy: ");


                do{
                    subjectId = new Scanner(System.in).nextInt();
                    subjectId = searchSubjectById(subjectId);
                    if(subjectId != -1){
                        break;
                    }
                    System.out.println("Không tồn tại id môn học, vui lòng nhập lại id môn học: ");
                }while (true);


                // check xem neu subjectId đó tồn tại thì gán vào cho subject mới
                Subject subject = getSubjectById(subjectId);

                System.out.println("Nhập số lớp của môn thứ " + (j + 1) + " mà giảng viên " + teachers[id-100].getName() + " dạy:");
                do {
                    tongSoLopCuaMon = new Scanner(System.in).nextInt();
                    if (tongSoLopCuaMon <= 0 || tongSoLopCuaMon > 3) {
                        System.out.println("Một gv ko dạy quá 3 lớp!Nhập lại: ");
                        check = false;
                    }
                    else {
                        check = true;
                    }
                } while (!check);
                check = true;
                // tổng số tiết của gv = số tiết môn * số lớp môn đó

                tongSoTietCua1mon =  subjects[j].getSoTiet() * tongSoLopCuaMon;
                tongSoTietCuaGv += tongSoTietCua1mon;
                if (tongSoTietCuaGv > 200) {
                    System.out.println("1 gv ko dạy quá 200 tiết!");
                    check = false;
                    break;
                } else check = true;
                check = true;
                salary += subject.getMucKinhPhi() * tongSoTietCua1mon;
                teachers[j].setSalary(salary);
                listMonGvDay[j] = subject;
                totalClassArray[j] = tongSoLopCuaMon;


            }
            Teaching teaching = new Teaching(teachers[id-100],listMonGvDay, totalClassArray,tongSoTietCuaGv);
            teachings[teachingallnum] = teaching;
            teachingallnum ++;

        } // end nhap thong tin
    }

    @Override
    public void sortByName() {
        if (teachings[0] == null) {
            System.out.println("Chưa có dữ liệu về giảng dạy, vui lòng kiểm tra lại quản lý giảng dạy");
            return;
        }

        for (int i = 0; i < teachingallnum; i++) {
            for (int j = i + 1; j < teachingallnum; j++) {
                if (teachings[i].getTeacher().getName().compareTo(teachings[j].getTeacher().getName()) > 0) {
                    Teaching tmp = teachings[i];
                    teachings[i] = teachings[j];
                    teachings[j] = tmp;
                }
            }
        }
    }

    @Override
    public void sortByLessionNum() {


        if (teachings[0] == null) {
            System.out.println("Chưa có dữ liệu về giảng dạy, vui lòng kiểm tra lại quản lý giảng dạy");
            return;
        }
        for (int i = 0; i < teachingallnum; i++) {
            for (int j = i + 1; j < teachingallnum; j++) {
                System.out.println(teachings[i].getTongSoTiet());
                if (teachings[i].getTongSoTiet()<teachings[j].getTongSoTiet()) {
                    Teaching tmp = teachings[i];
                    teachings[i] = teachings[j];
                    teachings[j] = tmp;
                }
            }
        }
    }

    public void showManagement(){
        for (Teaching t: teachings){
            if(t!= null){
                System.out.println(t);
            }else {
                break;
            }
        }
    }

    public void tinhLuong(){
        float sumSalary = 0;
        for(int i=0;i< teacherallnum;i++){
            sumSalary += teachers[i].getSalary();
            System.out.println("Lương của gv "+teachers[i].getName()+" là: "+sumSalary);
        }
    }

}
