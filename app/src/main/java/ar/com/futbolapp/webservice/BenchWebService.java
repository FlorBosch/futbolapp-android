package ar.com.futbolapp.webservice;

import ar.com.futbolapp.webservice.events.GetBenchPlayersSuccessEvent;
import flowengine.WebResponse;
import flowengine.annotations.webservice.FEWebService;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Ignacio on 28/02/2016.
 */
@FEWebService
public interface BenchWebService {

    @GET("/bench/{benchId}/player")
    public void getPlayers(@Path("benchId") Long benchId, WebResponse<GetBenchPlayersSuccessEvent> handler);

    @GET("/bench/{benchId}/player/{playerId}")
    public void getPlayer(@Path("benchId") Long benchId, @Path("playerId") Long playerId, WebResponse<GetBenchPlayersSuccessEvent> handler);

}
