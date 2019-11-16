package com.jagodawieczorek.todoapp.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jagodawieczorek.todoapp.task.Task;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Entity
public class Category extends RepresentationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final String id;
    private final String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Task> tasks;
}