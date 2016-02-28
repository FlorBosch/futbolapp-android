package ar.com.futbolapp.flows;

import ar.com.futbolapp.R;
import ar.com.futbolapp.ui.fragment.BenchRankingFragment;
import flowengine.Flow;
import flowengine.annotations.flow.FlowSteps;
import flowengine.annotations.flow.Sequence;
import flowengine.annotations.flow.StepContainer;

@FlowSteps(
        sequences = { @Sequence(id = "main", steps = {BenchRankingFragment.class})}
)
@StepContainer(R.id.container)
public interface BenchFlow extends Flow
{
}
