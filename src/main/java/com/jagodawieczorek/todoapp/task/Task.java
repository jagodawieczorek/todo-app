package com.jagodawieczorek.todoapp.task;

import lombok.*;

import javax.persistence.*;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    private String id;
    private String name;
    private String description;
}