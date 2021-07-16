package com.dio.firstProject.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class CalendarMovement {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private DateType dateType;
  private String description;
  private LocalDateTime specialDate;
}
