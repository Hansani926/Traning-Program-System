package lk.ijse.Training_System.model;

public class StudentTM {
    private String Id;
    private String StudentName;
    private String Address;
    private int Contact;
    private String dob;
    private String Gender;

    public StudentTM() {
    }

    public StudentTM(String id, String studentName, String address, int contact, String dob, String gender) {
        Id = id;
        StudentName = studentName;
        Address = address;
        Contact = contact;
        this.dob = dob;
        Gender = gender;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    public String getdob() {
        return dob;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "Id='" + Id + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact=" + Contact +
                ", dob='" + dob + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
