package models;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {

    public static void printFieldNamesAndValues(Object obj){
        for (Field field : obj.getClass().getDeclaredFields()) {
            System.out.println("Information for the field: " + field.getName());
            System.out.println("Name of the field: " + field.getName());
            System.out.println("Value of the field: " + field.getType());
            System.out.println("-----------------------------------");
        }
    }

    public static void invokePrivateMethod(Object obj, String methodName, Object... args){
        try{
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    method.setAccessible(true);
                    if (args.length == 0) {
                        method.invoke(obj);
                    } else {
                        method.invoke(obj, args);
                    }
                    return;
                }
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
