package com.tasksapi.tasksapi.wholeDATABASE.GoogleCalenderAPI_Integration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

    public interface EventRepository extends JpaRepository<Event, UUID> {
}






