package com.alirezabdn.easeit.ease;

import android.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by shadoWalker on 1/29/18.
 */

public class Ease {
    public static<T> void easeIt(final T t, View refView) {
        Method[] methods = t.getClass().getDeclaredMethods();
        for (final Method method : methods) {
            if (method.getAnnotation(OnClickOf.class) != null) {
                refView.findViewById(method.getAnnotation(OnClickOf.class).value()).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            method.setAccessible(true);
                            method.invoke(t);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}
