package com.train.app.util.raptor;

public class Connection {
    private final int destinationStopId;
    private final int routeId;
    private final long travelTime;

    public Connection(int destinationStopId, int routeId, long travelTime) {
        this.destinationStopId = destinationStopId;
        this.routeId = routeId;
        this.travelTime = travelTime;
    }

    public int getDestinationStopId() { return destinationStopId; }
    public int getRouteId() { return routeId; }
    public long getTravelTime() { return travelTime; }
}