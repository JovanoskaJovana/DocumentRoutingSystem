package mk.ukim.finki.routingsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "department_key_constraint",
                        columnNames = {"company_id", "department_key"})
        }
)
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "department_key")
    private String departmentKey;

    public Department() {
    }

    public Department(String name, String departmentKey, Company company) {
        this.name = name;
        this.departmentKey = departmentKey;
        this.company = company;
    }
}
