package com.alirezabdn.easeit.binder;

import android.content.Context;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by shadoWalker on 1/28/18.
 */

public class Binder {

    public static <T> void bind(Context context, T t, View root) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (View.class.isAssignableFrom(field.getType())) {
                field.setAccessible(true);
                try {
                    if (field.getAnnotation(BindStatus.class) != null) {
                        if (field.getAnnotation(BindStatus.class).value() == BindStatus.Status.DO_NOT_BIND)
                            continue;
                    }
                    if (field.getAnnotation(AssignView.class) != null)
                        field.set(t, root.findViewById(field.getAnnotation(AssignView.class).value()));
                    else
                        field.set(t, root.findViewById(getIdByName(context, field.getName())));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getIdByName(Context context, String name) throws NoSuchFieldException, IllegalAccessException {
        return context.getResources().getIdentifier(name, "id", context.getPackageName());
//        field.setAccessible(true);
//        return (int) field.get(R.id.class);
    }
}
