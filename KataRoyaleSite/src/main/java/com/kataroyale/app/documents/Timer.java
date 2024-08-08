package com.kataroyale.app.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "timers")
public class Timer {
    @Id
    private String nameOfTask;
    private LocalDateTime timeDone;
    private Integer timeBetweenInMinutes;
}
