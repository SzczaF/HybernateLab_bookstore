package pl.coderslab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String login;
    String password;
    String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", unique=true)
    PersonDetails personDetails;
}
