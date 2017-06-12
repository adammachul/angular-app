package org.queue.controllers;

import org.queue.models.Drug;
import org.queue.repositories.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drugs")
public class DrugController {

    @Autowired
    private DrugRepository drugRepository;

    @GetMapping
    public Page<Drug> getDrugs(Pageable page) {
        return drugRepository.findAll(page);
    }

    @GetMapping(value = "/{id}")
    public Drug getOneDrug(@RequestParam String id) {
        Drug drug = drugRepository.findOne(id);
        return drug;
    }

}
