package com.cognizant.eremenko.competiotionGame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_case")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestCase {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    String uuid;
    String inputData;
    String outputData;
    @ManyToOne
    @JoinColumn(name = "task_name", nullable = false)
    @JsonIgnore
    Task task;
}
