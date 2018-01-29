package com.alirezabdn.easeit;

/**
 * Created by Administrator on 10/16/2017.
 */

public class State {

    private static int uniqueId = 0;
    private int id;
    private BinderFragment fragment;
    private boolean addToBackStack;
    private boolean replace;
    private boolean isAnimated;
    private int animNext;
    private int animLastGoNext;
    private int animLastBackPrevious;
    private int animBackPrevious;

    public State(BinderFragment fragment) {
        this(fragment, true, true, false, 0, 0, 0, 0);
    }

    public State(BinderFragment fragment, boolean addToBackStack) {
        this(fragment, addToBackStack, true, false, 0, 0, 0, 0);
    }

    public State(BinderFragment fragment, boolean addToBackStack, boolean replace) {
        this(fragment, addToBackStack, replace, false, 0, 0, 0, 0);
    }

    public State(BinderFragment fragment,
                 boolean addToBackStack,
                 boolean replace,
                 boolean isAnimated,
                 int animNext,
                 int animLastGoNext,
                 int animLastBackPrevious,
                 int animBackPrevious) {
        uniqueId++;
        this.id = uniqueId;
        this.fragment = fragment;
        this.addToBackStack = addToBackStack;
        this.isAnimated = isAnimated;
        this.replace = replace;
        this.animNext = animNext;
        this.animLastGoNext = animLastGoNext;
        this.animLastBackPrevious = animLastBackPrevious;
        this.animBackPrevious = animBackPrevious;
    }

    public boolean isAddToBackStack() {
        return addToBackStack;
    }

    public void setAddToBackStack(boolean addToBackStack) {
        this.addToBackStack = addToBackStack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BinderFragment getFragment() {
        return fragment;
    }

    public void setFragment(BinderFragment fragment) {
        this.fragment = fragment;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }

    public int getAnimNext() {
        return animNext;
    }

    public void setAnimNext(int animNext) {
        this.animNext = animNext;
    }

    public int getAnimLastGoNext() {
        return animLastGoNext;
    }

    public void setAnimLastGoNext(int animLastGoNext) {
        this.animLastGoNext = animLastGoNext;
    }

    public int getAnimLastBackPrevious() {
        return animLastBackPrevious;
    }

    public void setAnimLastBackPrevious(int animLastBackPrevious) {
        this.animLastBackPrevious = animLastBackPrevious;
    }

    public int getAnimBackPrevious() {
        return animBackPrevious;
    }

    public void setAnimBackPrevious(int animBackPrevious) {
        this.animBackPrevious = animBackPrevious;
    }
}
