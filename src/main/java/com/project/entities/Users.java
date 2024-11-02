package com.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Micro_users")
public class Users{
    @Id
    @Column(name = "ID")
    private  String userId;

    @Column(length = 20)
    private String userName;

    private String email;
}
