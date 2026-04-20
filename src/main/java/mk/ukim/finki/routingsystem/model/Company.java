package mk.ukim.finki.routingsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    private Boolean active;


    public Company() {
    }

    public Company(Long id, String name, String code, Boolean active) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.active = active;
    }


}
