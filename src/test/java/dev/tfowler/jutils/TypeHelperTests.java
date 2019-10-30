package dev.tfowler.jutils;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TypeHelperTests {
  private List<Class<?>> primitiveNumericTypes;

  private List<Class<?>> primitiveOtherTypes;

  @Before
  public void setUpPrimitiveTypes() {
    primitiveNumericTypes =
        Arrays.asList(short.class, int.class, long.class, float.class, double.class);

    primitiveOtherTypes = Arrays.asList(byte.class, boolean.class, char.class);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBoxOfNonPrimitive() {
    TypeHelper.boxPrimitive(Object.class);
  }

  @Test
  public void testBoxForNumericTypes() {
    List<Class<?>> boxedNumericTypes = new ArrayList<>();
    primitiveNumericTypes.forEach(cl -> boxedNumericTypes.add(TypeHelper.boxPrimitive(cl)));
    assertThat(boxedNumericTypes, hasItem(anyOf(equalTo(Short.class), equalTo(Integer.class),
        equalTo(Long.class), equalTo(Float.class), equalTo(Double.class))));
  }

  @Test
  public void testBoxForOtherTypes() {
    List<Class<?>> boxedOtherTypes = new ArrayList<>();
    primitiveOtherTypes.forEach(cl -> boxedOtherTypes.add(TypeHelper.boxPrimitive(cl)));
    assertThat(boxedOtherTypes,
        hasItem(anyOf(equalTo(Byte.class), equalTo(Boolean.class), equalTo(Character.class))));
  }

  @Test
  public void testPrimitivenessCheckValid() {
    primitiveNumericTypes.forEach(cl -> assertTrue(TypeHelper.isPrimitive(cl)));
    primitiveOtherTypes.forEach(cl -> assertTrue(TypeHelper.isPrimitive(cl)));
    assertFalse(TypeHelper.isPrimitive(Object.class));
  }
}
