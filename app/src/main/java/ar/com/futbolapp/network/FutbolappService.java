package ar.com.futbolapp.network;


import java.util.Map;

import ar.com.futbolapp.domain.Match;
import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.domain.Team;
import retrofit2.http.GET;
import rx.Observable;

public interface FutbolappService {

    @GET("/matches.json")
    Observable<Map<String, Match>> getMatches();


    @GET("/teams.json")
    Observable<Map<String, Team>> getTeams();

    @GET("/users.json")
    Observable<Map<String, Player>> getPlayers();
}
