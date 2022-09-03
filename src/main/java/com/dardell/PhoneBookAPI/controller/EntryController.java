package com.dardell.PhoneBookAPI.controller;

import com.dardell.PhoneBookAPI.model.Entry;
import com.dardell.PhoneBookAPI.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EntryController {

    @Autowired
    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping("/entries")
    public Entry createEntry(@RequestBody Entry entry){
        return entryService.createEntry(entry);
    }

    @GetMapping("/entries")
    public List<Entry> getAllEntries() {
        return entryService.getAllEntries();
    }

    @DeleteMapping("/entries/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEntry(@PathVariable Long id) {
        boolean deleted = false;
        deleted = entryService.deleteEntry(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/entries/{id}")
    public ResponseEntity<Entry> getEntryById(@PathVariable Long id) {
        Entry entry = null;
        entry = entryService.getEntryById(id);
        return  ResponseEntity.ok(entry);
    }

    @PutMapping("/entries/{id}")
    public  ResponseEntity<Entry> updateEntry(@PathVariable Long id,
                                              @RequestBody Entry entry) {
        entry = entryService.updateEntry(id, entry);
        return ResponseEntity.ok(entry);
    }
}
