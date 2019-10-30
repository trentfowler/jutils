package dev.tfowler.jutils.models.adventureworks.person;

import dev.tfowler.jutils.query.Entity;
import lombok.Data;

@Entity
@Data
public class Person {

  private Integer businessEntityId;

  private String personType;

  private Boolean nameStyle;

  private String title;

  private String firstName;

  private String middleName;

  private String lastName;

  private String suffix;

  private Integer emailPromotion;

  private String additionalContactInfo;

  private String demographics;

  private String rowguid;

  private java.sql.Timestamp modifiedDate;
}
