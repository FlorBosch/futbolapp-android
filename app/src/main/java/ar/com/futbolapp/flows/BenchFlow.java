package ar.com.futbolapp.flows;

import ar.com.futbolapp.R;
import ar.com.futbolapp.ui.fragment.BenchDashboardFragment;
import ar.com.futbolapp.ui.fragment.BenchPlayerDetailFragment;
import ar.com.futbolapp.ui.fragment.BenchRankingFragment;
import flowengine.Flow;
import flowengine.annotations.flow.FlowSteps;
import flowengine.annotations.flow.Sequence;
import flowengine.annotations.flow.StepContainer;
import flowengine.annotations.flow.methods.GetModel;
import flowengine.annotations.flow.methods.Next;
import flowengine.annotations.flow.methods.SetModel;
import flowengine.annotations.flow.parameters.Argument;

@FlowSteps(
        sequences = {
                @Sequence(id = "main", steps = { BenchDashboardFragment.class }),
                @Sequence(id = "events", steps = {}),
                @Sequence(id = "stats", steps = {}),
                @Sequence(id = "history", steps = {}),
                @Sequence(id = "ranking", steps = {BenchRankingFragment.class, BenchPlayerDetailFragment.class})
        }
)
@StepContainer(R.id.container)
public interface BenchFlow extends Flow{

    @Next
    void viewPlayerDetail(@Argument("id") Long id);

    @Next("ranking")
    void viewRanking();

    @Next("events")
    void viewEvents();

    @Next("events")
    void viewHistory();

    @Next("stats")
    void viewOverallStats();

    @GetModel("currentPlayerId")
    Long getCurrentPlayerId();

    @SetModel("currentPlayerId")
    void setCurrentPlayerId(Long id);

    @GetModel("currentBenchId")
    Long getCurrentBenchId();

    @SetModel("currentBenchId")
    void setCurrentBenchId(Long id);
}
