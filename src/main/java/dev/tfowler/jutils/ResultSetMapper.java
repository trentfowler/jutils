package dev.tfowler.jutils;

import dev.tfowler.jutils.query.Entity;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultSetMapper {

  public static <T> T mapToEntity(final ResultSet rset, final Class<T> entityType)
      throws Exception {
    validateEntity(entityType);
    if (!rset.next()) {
      throw new Exception("err: no results");
    }
    T entity = entityType.newInstance();
    for (Field field : entityType.getDeclaredFields()) {
      Class<?> boxedType = TypeHelper.boxedType(field.getType());
      Object boxed = boxedType.cast(rset.getObject(field.getName()));
      field.setAccessible(true);
      field.set(entity, boxed);
    }
    if (rset.next()) {
      throw new Exception("err: too many results");
    }
    return entity;
  }

  public static <T> List<T> mapToList(final ResultSet rset, final Class<T> entityType)
      throws Exception {
    validateEntity(entityType);
    final List<T> entityList = new ArrayList<>();
    while (rset.next()) {
      T entity = entityType.newInstance();
      for (Field field : entityType.getDeclaredFields()) {
        Class<?> boxedType = TypeHelper.boxedType(field.getType());
        Object boxed = boxedType.cast(rset.getObject(field.getName()));
        field.setAccessible(true);
        field.set(entity, boxed);
      }
      entityList.add(entity);
    }
    return entityList;
  }

  private static void validateEntity(final Class<?> entityType) {
    if (!entityType.isAnnotationPresent(Entity.class)) {
      throw new IllegalArgumentException(
          String.format("Invalid entity type '%s'. Class definition must be annotated with @Entity",
              entityType.getSimpleName()));
    }
  }
}
