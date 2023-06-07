package jpabucket.bucketlist.repository;

import jpabucket.bucketlist.domain.Register;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterSimpleQueryDto {
    private Long registerId;
    private String name;
    private String goal;
    private LocalDate targetDate;


    public RegisterSimpleQueryDto(Long registerId, String name, String goal, LocalDate targetDate) {
        this.registerId = registerId;
        this.name = name;
        this.goal = goal;
        this.targetDate = targetDate;
    }

}
