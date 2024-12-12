package com.train.app.model.dto;

import com.train.app.model.entity.Travel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelResult {
    private Travel travel;
    private int startId;
    private int endId;
}
