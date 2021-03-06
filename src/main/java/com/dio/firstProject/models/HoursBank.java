package com.dio.firstProject.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class HoursBank {

  @AllArgsConstructor
  @NoArgsConstructor
  @EqualsAndHashCode
  @Embeddable
  @Getter
  @Setter
  public static class HoursBankId implements Serializable {
    private long hoursBankId;
    private long movementId;
    private long userId;
  }

  @EmbeddedId
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private HoursBankId id;
  private LocalDateTime workedDate;
  private BigDecimal quantityHours;
  private BigDecimal totalHours;
  @ManyToOne
  private CalendarMovement calendarMovement;
}