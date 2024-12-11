package bg.softuni.MobLeLeLe.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    private LocalDateTime created;

    private LocalDateTime modified;

}
