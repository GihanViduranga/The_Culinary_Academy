package ly.pt.viewTm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ly.pt.entity.Course;
import ly.pt.entity.Student;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationTM {
    private Long id;
    private String duration;
    private LocalDate date;
    private int sid;
    private String studentName;
    private String courseId;
    private String courseName;
    private double payment;
    private double dueAmount;
    private String Status;
}
