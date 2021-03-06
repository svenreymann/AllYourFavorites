package de.neuefische.allyourfavorites.utils;

import de.neuefische.allyourfavorites.dto.ApiSoccerMatch;
import de.neuefische.allyourfavorites.model.SoccerMatch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class SoccerMatchUtils {

    public List<SoccerMatch> buildSoccerMatch(List<ApiSoccerMatch> apiSoccerMatches) {
        List<SoccerMatch> formattedSoccerMatches = new ArrayList<>();
        for(ApiSoccerMatch apiSoccerMatch : apiSoccerMatches) {
            String[] goalsOfTeams = getGoalsOfTeams(apiSoccerMatch);
            String goalsHomeTeam = goalsOfTeams[0];
            String goalsAwayTeam = goalsOfTeams[1];
            SoccerMatch formattedSoccerMatch = new SoccerMatch(
                    apiSoccerMatch.getId(),
                    apiSoccerMatch.getMatchday(),
                    apiSoccerMatch.getUtcDate(),
                    apiSoccerMatch.getStatus(),
                    apiSoccerMatch.getCompetition().getId(),
                    apiSoccerMatch.getCompetition().getName(),
                    apiSoccerMatch.getGroup(),
                    apiSoccerMatch.getHomeTeam(),
                    apiSoccerMatch.getAwayTeam(),
                    goalsHomeTeam,
                    goalsAwayTeam);
            formattedSoccerMatches.add(formattedSoccerMatch);
        }
        return formattedSoccerMatches;
    }

    private String[] getGoalsOfTeams(ApiSoccerMatch apiSoccerMatch) {
        String[] goalsOfTeams = new String[2];
        goalsOfTeams[0] = "-";
        goalsOfTeams[1] = "-";
        if (apiSoccerMatch.getStatus().equals("FINISHED")
                || apiSoccerMatch.getStatus().equals("IN_PLAY")
                || apiSoccerMatch.getStatus().equals("PAUSED")) {
            goalsOfTeams[0] = apiSoccerMatch.getScore().getFullTime().getHomeTeam();
            goalsOfTeams[1] = apiSoccerMatch.getScore().getFullTime().getAwayTeam();
        }
        return goalsOfTeams;
    }

    public  List<SoccerMatch> getMatches(List<SoccerMatch> soccerMatches) {
        List<SoccerMatch> listOfMatches = new ArrayList<>();
        listOfMatches.add(getLastMatch(soccerMatches));
        listOfMatches.add(getCurrentMatch(soccerMatches));
        listOfMatches.add(getNextMatch(soccerMatches));
        return listOfMatches;
    }

    public SoccerMatch getLastMatch(List<SoccerMatch> soccerMatches) {
        List<SoccerMatch> finishedSoccerMatches = sortFinishedMatches(soccerMatches);

        if(finishedSoccerMatches.size() < 2) {
            return createEmptyMatch();
        }

        finishedSoccerMatches.sort(Comparator.comparing(SoccerMatch::getMatchDate));
        return finishedSoccerMatches.get(finishedSoccerMatches.size()-2);
    }

    public SoccerMatch getCurrentMatch(List<SoccerMatch> soccerMatches) {
        List<SoccerMatch> finishedSoccerMatches = sortFinishedMatches(soccerMatches);

        if (finishedSoccerMatches.isEmpty()) {
            return createEmptyMatch();
        }

        return finishedSoccerMatches.get(finishedSoccerMatches.size()-1);
    }

    public SoccerMatch getNextMatch(List<SoccerMatch> soccerMatches) {
        List<SoccerMatch> notFinishedSoccerMatches = sortNotFinishedMatches(soccerMatches);

        if(notFinishedSoccerMatches.isEmpty()) {
            return createEmptyMatch();
        }

        return notFinishedSoccerMatches.get(0);
    }

    private List<SoccerMatch> sortFinishedMatches(List<SoccerMatch> soccerMatches) {
        List<SoccerMatch> finishedSoccerMatches = new ArrayList<>();

        for (SoccerMatch soccerMatch : soccerMatches) {
            if (soccerMatch.getStatus().equals("FINISHED")
                    || soccerMatch.getStatus().equals("IN_PLAY")
                    || soccerMatch.getStatus().equals("PAUSED")) {
                finishedSoccerMatches.add(soccerMatch);
            }
        }

        finishedSoccerMatches.sort(Comparator.comparing(SoccerMatch::getMatchDate));
        return finishedSoccerMatches;
    }

    private List<SoccerMatch> sortNotFinishedMatches(List<SoccerMatch> soccerMatches){
        List<SoccerMatch> notFinishedSoccerMatches = new ArrayList<>();

        for (SoccerMatch soccerMatch : soccerMatches) {
            if (soccerMatch.getStatus().equals("SCHEDULED")) {
                notFinishedSoccerMatches.add(soccerMatch);
            }
        }

        notFinishedSoccerMatches.sort(Comparator.comparing(SoccerMatch::getMatchDate));
        return notFinishedSoccerMatches;
    }

    private SoccerMatch createEmptyMatch() {
        return new SoccerMatch(
                "",
                "0",
                null,
                "",
                "0",
                "",
                null,
                null,
                null,
                "",
                "");
    }
}
