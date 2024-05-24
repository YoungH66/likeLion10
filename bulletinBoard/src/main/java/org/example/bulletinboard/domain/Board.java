package org.example.bulletinboard.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "board")
public class Board {
    @Id
    private Long id;
    private String name;
    private String title;
    private String password;
    private String content;
    @Column("created_at")
    private LocalDate createdAt;
    @Column("updated_at")
    private LocalDate updatedAt;
}
