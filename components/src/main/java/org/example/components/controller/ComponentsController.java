package org.example.components.controller;

import org.example.components.model.ComponentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/components")
public class ComponentsController {

    @GetMapping()
    public List<ComponentDto> getComponents(@RequestParam("_start") int page,
                                            @RequestParam("_end") int pageSize,
                                            @RequestParam("_sort") String sortBy,
                                            @RequestParam("_order") String orderBy
    ) {
        return Collections.emptyList();
    }
}
