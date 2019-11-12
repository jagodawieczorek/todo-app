package com.jagodawieczorek.todoapp.task;

import com.jagodawieczorek.todoapp.category.Category;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Date;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    @ManyToOne
    private Category category;
    @CreatedBy
    private User user;
    @CreatedDate
    private Date createdDate;
}