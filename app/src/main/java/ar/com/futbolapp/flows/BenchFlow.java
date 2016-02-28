package ar.com.futbolapp.flows;

import ar.com.futbolapp.ui.fragment.BenchRankingFragment;
import flowengine.annotations.flow.Flow;
import flowengine.annotations.flow.FlowSteps;
import flowengine.annotations.flow.Sequence;

/**
 * Created by Ignacio on 28/02/2016.
 */
@FlowSteps(
        sequences = { @Sequence(id = "main", steps = {BenchRankingFragment.class})}
)
public interface BenchFlow extends Flow {
}
