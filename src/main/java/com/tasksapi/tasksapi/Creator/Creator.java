package com.tasksapi.tasksapi.Creator;

import com.tasksapi.tasksapi.Event.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Creator {
    @Id
    private String id;
    private String email;
    private String displayName;
    private Boolean self;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;

}