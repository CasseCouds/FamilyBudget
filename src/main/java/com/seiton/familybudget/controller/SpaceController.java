package com.seiton.familybudget.controller;

import com.seiton.familybudget.model.Space;
import com.seiton.familybudget.service.SpaceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/telegramm")
public class SpaceController {

    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @PostMapping("/space/new")
    public long addSpace(@Valid @RequestBody Space space) {
        return spaceService.addSpace(space);
    }

    @GetMapping("/space/{id}")
    public Space getSpace(@PathVariable("id") long id) {
        return spaceService.getSpace(id);
    }

    @DeleteMapping("/space/{id}")
    public void deleteSpace(@PathVariable("id") long id) {
        spaceService.deleteSpace(id);
    }

    @PutMapping("/space/{id}")
    public void updateSpace(@PathVariable("id") long id, @Valid @RequestBody Space space) {
        spaceService.updateSpace(id, space);
    }
}
