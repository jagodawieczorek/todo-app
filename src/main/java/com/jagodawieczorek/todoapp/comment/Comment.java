package com.jagodawieczorek.todoapp.comment;

import com.jagodawieczorek.todoapp.task.Task;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Date;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Comment extends RepresentationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String commentContent;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @CreatedDate
    @Column(updatable = false)
    private Date createdDate;
    @CreatedBy
    @Column(updatable = false)
    private User createdBy;
}
