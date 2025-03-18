package project.demo.apiswagger.api.common.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ErrorCode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String lang;
}