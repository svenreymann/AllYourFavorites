package de.neuefische.allyourfavorites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiSoccerMatchList {

    private int count;
    private ApiFilter filters;
    private List<ApiSoccerMatch> matches;
}
