package ar.com.futbolapp.flows;

import ar.com.futbolapp.R;
import ar.com.futbolapp.ui.activity.BenchActivity;
import ar.com.futbolapp.ui.fragment.DashboardFragment;
import flowengine.Flow;
import flowengine.annotations.flow.FlowSteps;
import flowengine.annotations.flow.Sequence;
import flowengine.annotations.flow.StepContainer;
import flowengine.annotations.flow.methods.Jump;
import flowengine.annotations.flow.parameters.Argument;

/**
 * Created by Ignacio on 28/02/2016.
 */
@FlowSteps(
        sequences = {
                @Sequence(id = "main", steps = {DashboardFragment.class})
        })
@StepContainer(R.id.container)
public interface NavigationFlow extends Flow {


    @Jump(BenchActivity.class)
    void jumpToBench(@Argument("id") Long id);
}
