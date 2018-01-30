package com.alirezabdn.easeit.activityFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * Created by S on 1/21/2017.
 */

public class FragmentHelper {

    public static void goToFragment(Fragment fragmentToGo,
                                    FragmentManager fragmentManager,
                                    int container,
                                    boolean addToBackStack,
                                    boolean replace,
                                    boolean isAnimated,
                                    int animNext,
                                    int animLastGoNext,
                                    int animLastBackPrevious,
                                    int animBackPrevious) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (isAnimated) {
            fragmentTransaction.setCustomAnimations(animNext,
                    animLastGoNext,
                    animLastBackPrevious,
                    animBackPrevious);
        }
        Fragment oldFragment = fragmentManager.findFragmentByTag(fragmentToGo.getClass().getSimpleName());
        if (oldFragment == null || !replace) {
            fragmentTransaction.replace(container, fragmentToGo, fragmentToGo.getClass().getSimpleName());
            if (addToBackStack)
                fragmentTransaction.addToBackStack(null);
        } else {
            fragmentTransaction.replace(container, oldFragment, fragmentToGo.getClass().getSimpleName());
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    public static void goToFragment(Fragment fragmentToGo,
                                    FragmentManager fragmentManager,
                                    int container,
                                    boolean addToBackStack,
                                    boolean replace) {
        goToFragment(fragmentToGo,
                fragmentManager,
                container,
                addToBackStack,
                replace,
                false,
                0, 0, 0, 0);
    }

    public static void popFragment(FragmentManager fragmentManager) {
        fragmentManager.popBackStackImmediate();
    }

    public static void goToHome(FragmentManager fragmentManager) {
        try {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Fragment getVisibleFragment(FragmentManager fragmentManager, int containerId) {
        return fragmentManager.findFragmentById(containerId);
    }
}
