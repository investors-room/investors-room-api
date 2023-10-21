package com.habibi.stockstoryapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import java.time.LocalDateTime;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "storyId")
@Entity
public class StoryEntity {
    @Id @GeneratedValue
    private long storyId;
    private int userId;
    private LocalDateTime creationDt;
    private String content;
}
