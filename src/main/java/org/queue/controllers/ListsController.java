package org.queue.controllers;

import org.queue.models.Lists;
import org.queue.repositories.ListsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListsController {

    private Logger logger = LoggerFactory.getLogger(ListsController.class);

    @Autowired
    private ListsRepository listsRepository;

    @GetMapping
    public Page<Lists> getLists(Pageable page) {
        return listsRepository.findAll(page);
    }

    @PostMapping
    public Lists addNewList(@RequestBody Lists newList) {
        Lists resultList = listsRepository.save(newList);
        logger.info("Added new list [{}]", resultList.getName());
        return resultList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Lists getList(@PathVariable String id) {
        Lists lists = listsRepository.findOne(id);
        return lists;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public Lists deleteList(@PathVariable String id) {
        Lists lists = listsRepository.findOne(id);
        listsRepository.delete(lists);
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Lists updateList(@PathVariable String id, @RequestBody Lists newList) {
        Lists lists = listsRepository.findOne(id);
        lists.setElements(newList.getElements());
        listsRepository.delete(id);
        Lists resultList = listsRepository.save(lists);
        return resultList;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}/{elementId}")
    public Lists deleteElement(@PathVariable("id") String id, @PathVariable("elementId") String elementId) {
        Lists lists = listsRepository.findOne(id);
        List<String> tempList = lists.getElements();
        tempList.remove(Integer.parseInt(elementId));
        lists.setElements(tempList);
        listsRepository.delete(id);
        Lists resultList = listsRepository.save(lists);
        return resultList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public String addNewElement(@PathVariable String id, String newElement) {
        Lists lists = listsRepository.findOne(id);
        lists.getElements().add(newElement);
        logger.info("Dodano element " + newElement + " do listy");
        return newElement;
    }
}
