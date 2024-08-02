package com.kataroyale.app.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
@Document(collection = "competitors")
public class Competitor {

    @Id
    private String userName;
    private Boolean isCompeting;
    private Integer honorInBattle;
    private Integer honorOnLastReset;
    private Integer totalWins;
}
