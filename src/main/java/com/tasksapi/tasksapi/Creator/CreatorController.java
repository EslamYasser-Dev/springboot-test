package com.tasksapi.tasksapi.Creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/creators")
public class CreatorController {

    @Autowired
    private CreatorRepository creatorRepository;

    @GetMapping
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Creator> getCreatorById(@PathVariable String id) {
        Optional<Creator> creator = creatorRepository.findById(id);
        return creator.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Creator createCreator(@RequestBody Creator creator) {
        return creatorRepository.save(creator);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Creator> updateCreator(@PathVariable String id, @RequestBody Creator updatedCreator) {
        Optional<Creator> creator = creatorRepository.findById(id);
        if (creator.isPresent()) {
            updatedCreator.setId(id);
            return ResponseEntity.ok(creatorRepository.save(updatedCreator));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreator(@PathVariable String id) {
        Optional<Creator> creator = creatorRepository.findById(id);
        if (creator.isPresent()) {
            creatorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
