package com.tasksapi.tasksapi.Recurrence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recurrences")
public class RecurrenceController {

    @Autowired
    private RecurrenceRepository recurrenceRepository;

    @GetMapping
    public List<Recurrence> getAllRecurrences() {
        return recurrenceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurrence> getRecurrenceById(@PathVariable String id) {
        Optional<Recurrence> recurrence = recurrenceRepository.findById(id);
        return recurrence.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recurrence createRecurrence(@RequestBody Recurrence recurrence) {
        return recurrenceRepository.save(recurrence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurrence> updateRecurrence(@PathVariable String id, @RequestBody Recurrence updatedRecurrence) {
        Optional<Recurrence> recurrence = recurrenceRepository.findById(id);
        if (recurrence.isPresent()) {
            updatedRecurrence.setId(id);
            return ResponseEntity.ok(recurrenceRepository.save(updatedRecurrence));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurrence(@PathVariable String id) {
        Optional<Recurrence> recurrence = recurrenceRepository.findById(id);
        if (recurrence.isPresent()) {
            recurrenceRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
