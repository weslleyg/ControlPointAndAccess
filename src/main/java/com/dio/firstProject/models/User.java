package com.dio.firstProject.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private UserCategory userCategory;
  private String name;
  @ManyToOne
  private Company company;
  @ManyToOne
  private AccessLevel accessLevel;
  @ManyToOne
  private WorkJourney workJourney;
  private BigDecimal tolerance;
  private LocalDateTime beginJourney;
  private LocalDateTime endJourney;
}
