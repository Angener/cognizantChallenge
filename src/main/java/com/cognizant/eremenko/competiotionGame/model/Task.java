package com.cognizant.eremenko.competiotionGame.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "task")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    @Id
    String name;
    String description;
    @OneToMany(mappedBy = "task")
    List<TestCase> testCases;
    @ManyToMany(mappedBy = "tasks")
    Set<User> users;
}
