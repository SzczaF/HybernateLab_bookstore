package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="publishers")
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
