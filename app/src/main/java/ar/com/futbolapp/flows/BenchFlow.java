package ar.com.futbolapp.flows;

import android.support.v4.media.session.MediaSessionCompat;

import ar.com.futbolapp.R;
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
                @Sequence(id = "main", steps = {BenchRankingFragment.class, BenchPlayerDetailFragment.class})
        }
)
@StepContainer(R.id.container)
public interface BenchFlow extends Flow{

    @Next
    void viewPlayerDetail(@Argument("id") Long id);

    @GetModel("currentPlayerId")
    Long getCurrentPlayerId();

    @SetModel("currentPlayerId")
    void setCurrentPlayerId(Long id);

    @GetModel("currentBenchId")
    Long getCurrentBenchId();

    @SetModel("currentBenchId")
    void setCurrentBenchId(Long id);
}
