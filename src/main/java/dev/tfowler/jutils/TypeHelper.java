package dev.tfowler.jutils;

public class TypeHelper {
  private TypeHelper() {} // prevent instantiation

  /**
   * Takes a type as the sole parameter and returns whether it is a primitive data type or not.
   * 
   * @param cl The type to check for primitiveness.
   * @return {@code true} if primitive, otherwise {@code false}.
   */
  public static boolean isPrimitive(Class<?> cl) {
    return cl == int.class || cl == long.class || cl == double.class || cl == float.class
        || cl == boolean.class || cl == byte.class || cl == char.class || cl == short.class;
  }

  /**
   * Takes a primitive type as the sole parameter and returns its boxed (object) equivalent.
   * 
   * @param cl The primitive type to box.
   * @return The boxed type that matches the primitive type provided.
   */
  public static Class<?> boxPrimitive(Class<?> cl) {
    if (cl == int.class) {
      return Integer.class;
    }
    if (cl == long.class) {
      return Long.class;
    }
    if (cl == double.class) {
      return Double.class;
    }
    if (cl == float.class) {
      return Float.class;
    }
    if (cl == boolean.class) {
      return Boolean.class;
    }
    if (cl == byte.class) {
      return Byte.class;
    }
    if (cl == char.class) {
      return Character.class;
    }
    if (cl == short.class) {
      return Short.class;
    }
    throw new IllegalArgumentException(
        String.format("\"%s\" is not a primitive type.", cl.getName()));
  }

  public static Class<?> boxedType(Class<?> cl) {
    return isPrimitive(cl) ? boxPrimitive(cl) : cl;
  }
}
