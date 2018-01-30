package com.alirezabdn.easeit.activityFragment;

import android.support.v4.app.FragmentManager;

import com.alirezabdn.easeit.binder.BinderActivity;
import com.alirezabdn.easeit.binder.BinderFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 10/16/2017.
 */

public abstract class StateMachineCore extends BinderActivity {

    private List<State> stateList;

    private void addFragment(final BinderFragment fragmentToGo,
                             final boolean addToBackStack,
                             final boolean replace) {
        onBeforeFragmentSwitched(getVisibleFragment());
        addFragment(fragmentToGo, addToBackStack, replace, false, 0, 0, 0, 0);
        onAfterFragmentSwitched(fragmentToGo);
    }

    private void addFragment(final BinderFragment fragmentToGo,
                             final boolean addToBackStack,
                             final boolean replace,
                             final boolean isAnimated,
                             int animNext,
                             int animLastGoNext,
                             int animLastBackPrevious,
                             int animBackPrevious) {
        onBeforeFragmentSwitched(getVisibleFragment());
        if (!addToBackStack)
            goToHome();
        FragmentHelper.goToFragment(fragmentToGo,
                getSupportFragmentManager(),
                getFragmentContainer(),
                addToBackStack,
                replace,
                isAnimated,
                animNext,
                animLastGoNext,
                animLastBackPrevious,
                animBackPrevious);
        onAfterFragmentSwitched(fragmentToGo);
    }

    public void popFragment() {
        onBeforeFragmentSwitched(getVisibleFragment());
        stateList.remove(stateList.size() - 1);
        FragmentHelper.popFragment(getSupportFragmentManager());
        onAfterFragmentSwitched(getVisibleFragment());
    }

    public void goToHome() {
        try {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addState(State state) {
        if (stateList == null)
            stateList = new ArrayList<>();
        State tmp = isStateAlreadyExist(state);
        if (tmp == null) {
            getStateList().add(state);
        } else {
            getStateList().remove(tmp);
            getStateList().add(tmp);
        }
        goToState(getCurrentState());
    }

    public int size() {
        return stateList.size();
    }

    protected State getCurrentState() {
        return getStateList().get(getStateList().size() - 1);
    }

    private State isStateAlreadyExist(State state) {
        for (State tmp : stateList) {
            if (tmp.getId() == state.getId()) {
                return tmp;
            }
        }
        return null;
    }

    public BinderFragment getVisibleFragment() {
        return (BinderFragment) FragmentHelper.getVisibleFragment(getSupportFragmentManager(), getFragmentContainer());
    }

    private void goToState(State state) {
        addFragment(state.getFragment(),
                state.isAddToBackStack(),
                state.isReplace(),
                state.isAnimated(),
                state.getAnimNext(),
                state.getAnimLastGoNext(),
                state.getAnimLastBackPrevious(),
                state.getAnimBackPrevious());
    }

    public List<State> getStateList() {
        if (stateList == null)
            stateList = new ArrayList<>();
        return stateList;
    }

    protected abstract int getFragmentContainer();

    protected void onBeforeFragmentSwitched(BinderFragment oldFragment) {}

    protected void onAfterFragmentSwitched(BinderFragment oldFragment) {}
}
