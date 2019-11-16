package com.jagodawieczorek.todoapp.task;

import com.jagodawieczorek.todoapp.category.Category;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Task extends RepresentationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @CreatedBy
    private User createdBy;
    @CreatedDate
    private Date createdDate;
    @LastModifiedBy
    private User lastModifiedBy;
    @LastModifiedDate
    private Date lastModifiedDate;
}