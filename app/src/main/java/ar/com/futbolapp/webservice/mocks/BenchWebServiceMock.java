package ar.com.futbolapp.webservice.mocks;

import java.util.ArrayList;
import java.util.List;

import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.webservice.BenchWebService;
import ar.com.futbolapp.webservice.events.GetBenchPlayerSuccessEvent;
import ar.com.futbolapp.webservice.events.GetBenchPlayersSuccessEvent;
import flowengine.FlowEngine;
import flowengine.WebResponse;
import retrofit.http.Path;

/**
 * Created by Ignacio on 28/02/2016.
 */
public class BenchWebServiceMock implements BenchWebService {

    public List<Player> getMockedPlayersList() {
        List<Player> players = new ArrayList<>();
        Player a = getMockedPlayer();
        players.add(a);
        return players;
    }

    @Override
    public void getPlayers(@Path("benchId") Long benchId, WebResponse<GetBenchPlayersSuccessEvent> handler) {
        GetBenchPlayersSuccessEvent e = new GetBenchPlayersSuccessEvent();
        e.set(getMockedPlayersList());
        FlowEngine.getCurrentBus().post(e);
    }

    @Override
    public void getPlayer(@Path("benchId") Long benchId, @Path("playerId") Long playerId, WebResponse<GetBenchPlayersSuccessEvent> handler) {
        GetBenchPlayerSuccessEvent e = new GetBenchPlayerSuccessEvent();
        e.set(getMockedPlayer());
        FlowEngine.getCurrentBus().post(e);
    }

    public Player getMockedPlayer() {
        Player a = new Player();
        a.setId(1l);
        a.setName("Pablo Angelani");
        a.setAverage(5);
        return a;
    }
}
