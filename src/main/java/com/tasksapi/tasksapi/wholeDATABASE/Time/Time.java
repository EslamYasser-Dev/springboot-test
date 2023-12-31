package com.tasksapi.tasksapi.wholeDATABASE.Time;

import com.tasksapi.tasksapi.wholeDATABASE.GoogleCalenderAPI_Integration.Event;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Time {
    @Id
    private String id;
    private Date date;
    private Date dateTime;
    private String timeZone;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
}