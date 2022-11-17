package pt.amado.maindemoproject.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@Id", scope = Employee.class)
public class Employee {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Employee[" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ']';
    }
}
