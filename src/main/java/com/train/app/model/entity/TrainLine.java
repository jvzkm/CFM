package com.train.app.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "trainline")
public class TrainLine {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(nullable = false, length = 20)
    private String name;
}
