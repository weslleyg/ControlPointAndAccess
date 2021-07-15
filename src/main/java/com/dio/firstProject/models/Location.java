package com.dio.firstProject.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Location {
  @Id
  private long id;

  @ManyToOne
  private AccessLevel accessLevel;

  private String description;
}
