package lk.ijse.Training_System.dto;



public class RegistrationDTO {
    private int RegNo;
    private String RegDate;
    private double  RegFee;
    private StudentDTO studentDTO;
    private CourseDTO courseDTO;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int regNo, String regDate, double regFee, StudentDTO studentDTO, CourseDTO courseDTO) {
        RegNo = regNo;
        RegDate = regDate;
        RegFee = regFee;
        this.studentDTO = studentDTO;
        this.courseDTO = courseDTO;
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

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "RegNo=" + RegNo +
                ", RegDate='" + RegDate + '\'' +
                ", RegFee=" + RegFee +
                ", studentDTO=" + studentDTO +
                ", courseDTO=" + courseDTO +
                '}';
    }
}
