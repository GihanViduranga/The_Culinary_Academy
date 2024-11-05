package ly.pt.model;

import ly.pt.entity.Student;

public class StudentDTO {
    private String StudentId;
    private String StudentName;
    private String DateOfBirth;
    private String Address;
    private String PhoneNumber;
    private String Email;

    public StudentDTO() {
    }

    public StudentDTO(String studentId, String studentName, String dateOfBirth, String address, String phoneNumber, String email) {
        StudentId = studentId;
        StudentName = studentName;
        DateOfBirth = dateOfBirth;
        Address = address;
        PhoneNumber = phoneNumber;
        Email = email;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
