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
public class UserCategory {
  @Id
  private long id;
  private String description;
}
