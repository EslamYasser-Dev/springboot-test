package com.tasksapi.tasksapi.Organizer;

import com.tasksapi.tasksapi.Event.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Organizer {

    @Id
    private String id;
    private String email;
    private String displayName;
    private Boolean self;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
}

