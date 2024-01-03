package com.tasksapi.tasksapi.wholeDATABASE.Organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerRepository organizerRepository;

    @GetMapping
    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable String id) {
        Optional<Organizer> organizer = organizerRepository.findById(id);
        return organizer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable String id, @RequestBody Organizer updatedOrganizer) {
        Optional<Organizer> organizer = organizerRepository.findById(id);
        if (organizer.isPresent()) {
            updatedOrganizer.setId(id);
            return ResponseEntity.ok(organizerRepository.save(updatedOrganizer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable String id) {
        Optional<Organizer> organizer = organizerRepository.findById(id);
        if (organizer.isPresent()) {
            organizerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
