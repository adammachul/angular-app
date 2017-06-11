package org.queue.controllers;

import org.queue.models.Lists;
import org.queue.repositories.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lists")
public class ListsController {

    @Autowired
    private ListsRepository listsRepository;

    @GetMapping
    public Page<Lists> getLists(Pageable page) {
        return listsRepository.findAll(page);
    }
}
