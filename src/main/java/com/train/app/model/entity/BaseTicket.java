package com.train.app.model.entity;

import com.train.app.model.marker.HasId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "baseticket")
public class BaseTicket implements HasId<Integer> {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @Column(name = "boarding_station_index")
    private Integer boardingStationIndex;

    @Column(name = "exit_station_index")
    private Integer exitStationIndex;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "vagon_index")
    private Integer vagonIndex;

    @Column(name = "price")
    private Float price;

}