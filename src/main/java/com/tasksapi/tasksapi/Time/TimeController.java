package com.tasksapi.tasksapi.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/times")
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping
    public List<Time> getAllTimes() {
        return timeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> getTimeById(@PathVariable String id) {
        Optional<Time> time = timeRepository.findById(id);
        if (time.isPresent()) {
            return ResponseEntity.ok(time.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Time createTime(@RequestBody Time time) {
        return timeRepository.save(time);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> updateTime(@PathVariable String id, @RequestBody Time updatedTime) {
        Optional<Time> time = timeRepository.findById(id);
        if (time.isPresent()) {
            updatedTime.setId(id);
            return ResponseEntity.ok(timeRepository.save(updatedTime));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTime(@PathVariable String id) {
        Optional<Time> time = timeRepository.findById(id);
        if (time.isPresent()) {
            timeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
