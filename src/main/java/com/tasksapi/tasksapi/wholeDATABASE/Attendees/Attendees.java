package com.tasksapi.tasksapi.wholeDATABASE.Attendees;

import com.tasksapi.tasksapi.wholeDATABASE.GoogleCalenderAPI_Integration.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Attendees {
    @Id
    private String id;
    private String email;
    private String displayName;
    private Boolean organizer;
    private Boolean self;
    private Boolean resource;
    private Boolean optional;
    private String responseStatus;
    private String comment;
    private Integer additionalGuests;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
}