package de.neuefische.allyourfavorites.controllerTests;

import de.neuefische.allyourfavorites.db.UserDb;
import de.neuefische.allyourfavorites.dto.UserLoginDto;
import de.neuefische.allyourfavorites.model.SoccerTeam;
import de.neuefische.allyourfavorites.model.User;
import de.neuefische.allyourfavorites.service.ApiCrawler;
import de.neuefische.allyourfavorites.service.SoccerTeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"jwt.secretkey=sometoken"})
public class FavoriteControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserDb userDb;

    @MockBean
    private SoccerTeamService soccerTeamService;

    @MockBean
    private ApiCrawler apiCrawler;

    @BeforeEach
    public void setupDb() {
        userDb.deleteAll();
        String password = new BCryptPasswordEncoder().encode("123456");
        userDb.save(new User("sven", password, "emailadress@test.com", List.of()));
    }

    private String getSoccerTeamsUrl() {
        return "http://localhost:" + port + "/api";
    }

    private String login(){
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/auth/login", new UserLoginDto(
                "sven",
                "123456"
        ), String.class);

        return response.getBody();
    }

    private <T> HttpEntity<T> getValidAuthorizationEntity(T data) {
        String token = login();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        return new HttpEntity<>(data, headers);
    }

    @Test
    public void testGetMappingWithValidJwt() {
        //GIVEN
        List <SoccerTeam> listOfTeamsInSoccerTeamDb = new ArrayList<>(List.of(
                new SoccerTeam("1","Borussia Dortmund", "bvbUrl", "Bundesliga"),
                new SoccerTeam("2", "Bayern München", "fcbUrl", "Bundesliga"),
                new SoccerTeam("3", "Eintracht Frankfurt", "sgeUrl", "Bundesliga")
        ));

        String url = getSoccerTeamsUrl() + "/soccerTeams";
        when(soccerTeamService.getListOfSoccerTeams()).thenReturn(listOfTeamsInSoccerTeamDb);

        //WHEN
        HttpEntity<Void> entity = getValidAuthorizationEntity(null);
        ResponseEntity<SoccerTeam[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, SoccerTeam[].class);

        //THEN
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(listOfTeamsInSoccerTeamDb.toArray()));
    }

    @Test
    public void testGetMappingForbiddenWhenNoValidJWT() {
        // GIVEN
        String url = getSoccerTeamsUrl();

        // WHEN
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // THEN
        assertThat(response.getStatusCode(), is(HttpStatus.FORBIDDEN));
    }

}

