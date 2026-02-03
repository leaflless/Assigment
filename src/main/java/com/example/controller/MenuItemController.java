package com.example.controller;

import com.example.db.MenuItemDB;
import com.example.model.MenuItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return MenuItemDB.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createMenuItem(@RequestBody MenuItem item) {
        MenuItemDB.save(item);
        return ResponseEntity.ok("Created");
    }

    @PutMapping("/{name}")
    public ResponseEntity<String> updatePrice(@PathVariable String name, @RequestBody MenuItem item) {
        MenuItemDB.updatePrice(name, item.getPrice());
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable String name) {
        MenuItemDB.delete(name);
        return ResponseEntity.ok("Deleted");
    }
}


