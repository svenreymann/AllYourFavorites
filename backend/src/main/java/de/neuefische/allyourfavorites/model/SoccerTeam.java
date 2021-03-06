package de.neuefische.allyourfavorites.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "soccerTeams")
public class SoccerTeam {
    @Id
    private String teamId;
    private String name;
    private String crestUrl;
    private String competitionName;
}
