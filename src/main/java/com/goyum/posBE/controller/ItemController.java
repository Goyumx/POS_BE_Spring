package com.goyum.posBE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.goyum.posBE.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    
    @Autowired
    ItemService itemService;

    
}
