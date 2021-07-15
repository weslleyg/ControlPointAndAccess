package com.dio.firstProject.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Occurrence {
  @Id
  private long id;
  private String name;
  private String description;
}
