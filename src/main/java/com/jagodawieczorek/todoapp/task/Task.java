package com.jagodawieczorek.todoapp.task;

import com.jagodawieczorek.todoapp.category.Category;
import com.jagodawieczorek.todoapp.comment.Comment;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = false)
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
    @JoinColumn(name = "category_id")
    private Category category;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "task")
    private List<Comment> comments;
    @Lob
    private Byte[] image;
    @CreatedBy
    @Column(updatable = false)
    private User createdBy;
    @CreatedDate
    @Column(updatable = false)
    private Date createdDate;
    @LastModifiedBy
    private User lastModifiedBy;
    @LastModifiedDate
    private Date lastModifiedDate;

    public String toString() {
        return "Task(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription()
                + ", category=" + this.getCategory() + ", status=" + this.getStatus()
                + ", image=" + java.util.Arrays.deepToString(this.getImage()) + ", createdBy=" + this.getCreatedBy()
                + ", createdDate=" + this.getCreatedDate() + ", lastModifiedBy=" + this.getLastModifiedBy()
                + ", lastModifiedDate=" + this.getLastModifiedDate() + ")";
    }
}