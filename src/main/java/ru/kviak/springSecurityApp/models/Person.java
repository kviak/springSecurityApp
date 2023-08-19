package ru.kviak.springSecurityApp.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Person")
@NoArgsConstructor
@ToString
public class Person {

    @Getter@Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter@Setter
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длинной")
    @Column(name = "username")
    private String username;

    @Getter@Setter
    @Min(value = 1900, message = "Год рождения должен быть больше 1900")
    @Column(name="year_of_birth")
    private int yearOfBirth;

    @Getter@Setter
    @Column(name = "password")
    private String password;

    public Person(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }
}
