package com.nixsolution.ppp.reflections;

import com.nixsolutions.ppp.reflection.Ignore;
import com.nixsolutions.ppp.reflection.Info;
import com.nixsolutions.ppp.reflection.ReflectionUtil;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtilImpl implements ReflectionUtil {
    @Override
    public String toString(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ELEMENT_START);
        int countObjects = 0;
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Info.class)) {
                if (isBaseElement(field.getType())) {
                    try {
                        stringBuilder.append(field.getName())
                                .append(KEY_VALUE_SEPARATOR)
                                .append(field.get(object))
                                .append(ELEMENT_SEPARATOR);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Field[] declaredFields;
                    stringBuilder.append(field.getName()).append(KEY_VALUE_SEPARATOR);
                    try {
                        declaredFields = field.get(object).getClass().getDeclaredFields();
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    if (countObjects == 0) {
                        stringBuilder.append(ELEMENT_START);
                        countObjects++;
                    }
                    for (Field notBaseElementField : declaredFields) {
                        notBaseElementField.setAccessible(true);
                        if (notBaseElementField.isAnnotationPresent(Info.class)) {
                            try {
                                stringBuilder.append(notBaseElementField.getName())
                                        .append(KEY_VALUE_SEPARATOR)
                                        .append(notBaseElementField.get(field.get(object)))
                                        .append(ELEMENT_SEPARATOR);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    if (countObjects == 1) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1)
                                .append(ELEMENT_END).append(ELEMENT_SEPARATOR);
                        countObjects--;
                    }
                }
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(ELEMENT_END).toString();
    }

    @Override
    public boolean isTheSame(Object object1, Object object2) {
        if (object1 == object2) {
            return true;
        }
        if (object1 == null || object2 == null) {
            return false;
        }
        List<Field> fields1 = takeAllFieldsIgnored(object1.getClass().getDeclaredFields());
        List<Field> fields2 = takeAllFieldsIgnored(object2.getClass().getDeclaredFields());

        if (fields1.size() != fields2.size()) {
            return false;
        }
        try {
            for (int i = 0; i < fields1.size(); i++) {
                Field field1 = fields1.get(i);
                Field field2 = fields2.get(i);
                if (field1.getType().equals(field2.getType())) {

                    if (field1.get(object1).equals(field2.get(object2))) {
                        continue;
                    }
                    if (isBaseElement(field1.getType())) {

                        if (!field1.get(object1).equals(field2.get(object2))) {
                            return false;
                        }
                    } else {
                        if (!isTheSame(field1.get(object1), field2.get(object2))) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private List<Field> takeAllFieldsIgnored(Field[] fields) {
        for (Field field : fields) {
            field.setAccessible(true);
        }
        return Arrays.stream(fields)
                .filter(field -> Arrays.stream(field.getAnnotations())
                        .noneMatch(annotation -> annotation.annotationType().equals(Ignore.class))).collect(Collectors.toList());
    }
}
