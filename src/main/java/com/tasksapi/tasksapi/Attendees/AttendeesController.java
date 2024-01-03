package com.tasksapi.tasksapi.Attendees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendees")
public class AttendeesController {

    @Autowired
    private AttendeesRepository attendeesRepository;

    @GetMapping
    public List<Attendees> getAllAttendees() {
        return attendeesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendees> getAttendeeById(@PathVariable String id) {
        Optional<Attendees> attendee = attendeesRepository.findById(id);
        return attendee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Attendees createAttendee(@RequestBody Attendees attendee) {
        return attendeesRepository.save(attendee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendees> updateAttendee(@PathVariable String id, @RequestBody Attendees updatedAttendee) {
        Optional<Attendees> attendee = attendeesRepository.findById(id);
        if (attendee.isPresent()) {
            updatedAttendee.setId(id);
            return ResponseEntity.ok(attendeesRepository.save(updatedAttendee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendee(@PathVariable String id) {
        Optional<Attendees> attendee = attendeesRepository.findById(id);
        if (attendee.isPresent()) {
            attendeesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
