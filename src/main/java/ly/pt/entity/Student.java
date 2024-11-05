package ly.pt.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private Student StudentId;
    private String StudentName;
    private String DateOfBirth;
    private String Address;
    private String PhoneNumber;

    @Column(unique = true)
    private String Email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentRegistration> studentRegistrations = new ArrayList<>();

    public Student(String studentId, String studentName, String dateOfBirth, String address, String phoneNumber, String email) {
    }

    public Student(Student studentId, String studentName, String dateOfBirth, String address, String phoneNumber, String email) {
        StudentId = studentId;
        StudentName = studentName;
        DateOfBirth = dateOfBirth;
        Address = address;
        PhoneNumber = phoneNumber;
        Email = email;
    }

    public Student getStudentId() {
        return StudentId;
    }

    public void setStudentId(Student studentId) {
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
