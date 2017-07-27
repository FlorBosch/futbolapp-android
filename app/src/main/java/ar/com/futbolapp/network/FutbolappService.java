package ar.com.futbolapp.network;


import ar.com.futbolapp.domain.Match;
import ar.com.futbolapp.domain.Team;
import retrofit2.http.GET;
import rx.Observable;

public interface FutbolappService {

    @GET("matches")
    Observable<Match> getMatches();


    @GET("teams")
    Observable<Team> getTeams();
}
