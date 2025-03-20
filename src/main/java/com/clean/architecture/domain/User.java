
package com.clean.architecture.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid", columnDefinition = "varchar")
    private String uid;

    @Column(name = "type", columnDefinition = "varchar")
    private String type;

    @Column(name = "is_active", columnDefinition = "varchar")
    private Boolean isActive;
}
