package com.train.app.model.dto;

import com.train.app.model.entity.TrainLine;
import lombok.Data;

@Data
public class TrainLineInfo {
    private TrainLine trainLine;
    private int elementCount;

    public TrainLineInfo(TrainLine trainLine, long elementCount) {
        this.trainLine = trainLine;
        this.elementCount = (int) elementCount;
    }

    public TrainLineInfo() {
    }
}
