package com.tasksapi.tasksapi.wholeDATABASE.GoogleCalenderAPI_Integration;

import com.tasksapi.tasksapi.wholeDATABASE.Attendees.Attendees;
import com.tasksapi.tasksapi.wholeDATABASE.Creator.Creator;
import com.tasksapi.tasksapi.wholeDATABASE.ExtendedProperties.ExtendedProperties;
import com.tasksapi.tasksapi.wholeDATABASE.Organizer.Organizer;
import com.tasksapi.tasksapi.wholeDATABASE.Recurrence.Recurrence;
import com.tasksapi.tasksapi.wholeDATABASE.Time.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Event {
    @jakarta.persistence.Id
    private String id;
    private String kind;
    private String etag;
    private String status;
    private String htmlLink;
    private Date created;
    private Date updated;
    private String summary;
    private String description;
    private String location;
    private String colorId;
    private String recurringEventId;
    private String transparency;
    private String visibility;
    private String iCalUID;
    private Integer sequence;
    private Boolean attendeesOmitted;
    private String hangoutLink;
    private Boolean anyoneCanAddSelf;
    private Boolean guestsCanInviteOthers;
    private Boolean guestsCanModify;
    private Boolean guestsCanSeeOtherGuests;
    private Boolean privateCopy;
    private Boolean locked;
    private String eventType;

    @OneToMany(mappedBy = "event")
    private List<Creator> creators;

    @OneToMany(mappedBy = "event")
    private List<Organizer> organizers;

    @OneToMany(mappedBy = "event")
    private List<Time> times;

    @OneToMany(mappedBy = "event")
    private List<Recurrence> recurrences;

    @OneToMany(mappedBy = "event")
    private List<Attendees> attendees;

    @OneToMany(mappedBy = "event")
    private List<ExtendedProperties> extendedProperties;

}