package lk.ijse.Training_System.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration implements SuperEntity{
    @Id
    private int RegNo;
    private String RegDate;
    private double  RegFee;
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    private  Course course;

    public Registration() {
    }


    public Registration(int regNo, String regDate, double regFee, Student student, Course course) {
        RegNo = regNo;
        RegDate = regDate;
        RegFee = regFee;
        this.student = student;
        this.course = course;
    }

    public int getRegNo() {
        return RegNo;
    }

    public void setRegNo(int regNo) {
        RegNo = regNo;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public double getRegFee() {
        return RegFee;
    }

    public void setRegFee(double regFee) {
        RegFee = regFee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "RegNo=" + RegNo +
                ", RegDate='" + RegDate + '\'' +
                ", RegFee=" + RegFee +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
