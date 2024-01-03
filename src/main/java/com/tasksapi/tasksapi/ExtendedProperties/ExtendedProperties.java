package com.tasksapi.tasksapi.ExtendedProperties;

import com.tasksapi.tasksapi.Event.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ExtendedProperties {
    @Id
    private String id;
    private String isPrivate;
    private String shared;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
}