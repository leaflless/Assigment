package org.example.restaurant;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository repo;

    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Item> getAll() throws Exception {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Item getOne(@PathVariable int id) throws Exception {
        return repo.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Item item) throws Exception {
        repo.save(item);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Item item) throws Exception {
        repo.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception {
        repo.delete(id);
    }
}