package com.train.app.model.dto;

import com.train.app.model.entity.Station;
import com.train.app.model.entity.Travel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TicketMetaData {
    private Station startStation;
    private LocalDateTime departureTime;
    private Station stopStation;
    private LocalDateTime arrivalTime;
    private Travel travel;
    private Double km;
}
