package Entity.Cats;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "cats", name = "cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false, unique = true)
    private long id;

    @Column(name = "imię")
    private String name;

    @Column(name = "wiek")
    private int age;

    @Column(name = "złapane szczury")
    private int numberOfRats;
}
