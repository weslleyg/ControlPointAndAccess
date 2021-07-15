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
public class Company {
  @Id
  private long id;
  private String description;
  private String cnpj;
  private String location;
  private String distric;
  private String city;
  private String state;
  private String phoneNumber;
}
