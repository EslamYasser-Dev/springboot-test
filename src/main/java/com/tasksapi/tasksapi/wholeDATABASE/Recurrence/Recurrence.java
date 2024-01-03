package com.tasksapi.tasksapi.wholeDATABASE.Recurrence;

import com.tasksapi.tasksapi.wholeDATABASE.GoogleCalenderAPI_Integration.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Recurrence {
    @Id
    private String id;
    private String recurrence;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
}