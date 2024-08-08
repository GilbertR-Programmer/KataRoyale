package com.kataroyale.app.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "timers")
public class Timer {
    private String nameOfTask;
    private LocalDateTime timeDone;
    private Integer timeBetweenInMinutes;
}
