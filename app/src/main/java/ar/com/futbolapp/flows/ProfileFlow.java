package ar.com.futbolapp.flows;

import ar.com.futbolapp.R;
import ar.com.futbolapp.ui.fragment.EditProfileFragment;
import ar.com.futbolapp.ui.fragment.ProfileFragment;
import flowengine.Flow;
import flowengine.annotations.flow.FlowSteps;
import flowengine.annotations.flow.Sequence;
import flowengine.annotations.flow.StepContainer;
import flowengine.annotations.flow.methods.Exit;
import flowengine.annotations.flow.methods.Next;

@FlowSteps(
        sequences = { @Sequence(id = "main", steps = {ProfileFragment.class, EditProfileFragment.class})}
)
@StepContainer(R.id.container)
public interface ProfileFlow extends Flow {

    @Next void next();

    @Exit void exit();
}
