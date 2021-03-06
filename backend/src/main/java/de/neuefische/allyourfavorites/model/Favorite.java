package de.neuefische.allyourfavorites.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "soccerMatchesByTeam")
public class Favorite {
    @Id
    private String teamId;
    private String name;
    private String crestUrl;
    private List<SoccerMatch> matches;

}
