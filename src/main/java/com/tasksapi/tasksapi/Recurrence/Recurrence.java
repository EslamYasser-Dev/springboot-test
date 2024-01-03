package com.tasksapi.tasksapi.Recurrence;

import com.tasksapi.tasksapi.Event.Event;
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