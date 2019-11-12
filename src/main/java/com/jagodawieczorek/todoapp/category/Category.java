package com.jagodawieczorek.todoapp.category;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "categories")
public class Category extends RepresentationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
}
