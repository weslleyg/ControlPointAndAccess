package com.dio.firstProject.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Movement {

  @AllArgsConstructor
  @NoArgsConstructor
  @EqualsAndHashCode
  @Getter
  @Setter
  @Embeddable
  public static class MovementId implements Serializable {
    private long movementId;
    private long userId;
  }

  @EmbeddedId
  private MovementId id;
  private LocalDateTime entryDate;
  private LocalDateTime exitDate;
  private BigDecimal period;
  @ManyToOne
  private Occurrence occurrence;
  @ManyToOne
  private CalendarMovement calendarMovement;
}