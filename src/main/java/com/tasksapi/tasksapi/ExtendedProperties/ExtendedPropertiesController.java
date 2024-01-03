package com.tasksapi.tasksapi.ExtendedProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/extendedProperties")
public class ExtendedPropertiesController {

    @Autowired
    private ExtendedPropertiesRepository extendedPropertiesRepository;

    @GetMapping
    public List<ExtendedProperties> getAllExtendedProperties() {
        return extendedPropertiesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtendedProperties> getExtendedPropertyById(@PathVariable String id) {
        Optional<ExtendedProperties> extendedProperty = extendedPropertiesRepository.findById(id);
        return extendedProperty.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExtendedProperties createExtendedProperty(@RequestBody ExtendedProperties extendedProperty) {
        return extendedPropertiesRepository.save(extendedProperty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExtendedProperties> updateExtendedProperty(@PathVariable String id, @RequestBody ExtendedProperties updatedExtendedProperty) {
        Optional<ExtendedProperties> extendedProperty = extendedPropertiesRepository.findById(id);
        if (extendedProperty.isPresent()) {
            updatedExtendedProperty.setId(id);
            return ResponseEntity.ok(extendedPropertiesRepository.save(updatedExtendedProperty));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExtendedProperty(@PathVariable String id) {
        Optional<ExtendedProperties> extendedProperty = extendedPropertiesRepository.findById(id);
        if (extendedProperty.isPresent()) {
            extendedPropertiesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
