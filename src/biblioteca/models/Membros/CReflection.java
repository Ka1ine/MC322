package biblioteca.models.Membros;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CReflection {
    public enum Classes {
        EMPLOYEE(Employee.class),
        TEACHER(Teacher.class),
        POSTGRADUATE(Postgraduate.class),
        UNDERGRADUATE(Undergraduate.class);

        private Class<?> associatedClass;

        Classes(Class<?> associatedClass) {
            this.associatedClass = associatedClass;
        }

        public Class<?> getAssociatedClass() {
            return associatedClass;
        }
    }

    public static void imprimirAtributos(Classes obj) {
        Class<?> classe = obj.getAssociatedClass();

        while (classe != null) {
            Field[] atributos = classe.getDeclaredFields();

            for (Field atributo : atributos) {
                System.out.println("Atributo: " + atributo.getName());
            }

            classe = classe.getSuperclass();
        }
    }

    public static void imprimirMetodos(Classes obj) {
        Class<?> classe = obj.getAssociatedClass();

        while (classe != null) {
            Method[] metodos = classe.getDeclaredMethods();

            for (Method metodo : metodos) {
                if (!metodo.getDeclaringClass().equals(Object.class)) {
                    System.out.println("Método: " + metodo.getName());
                }
            }

            classe = classe.getSuperclass();
        }
    }
}
