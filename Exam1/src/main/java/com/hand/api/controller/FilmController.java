package com.hand.api.controller;

import javax.annotation.Resource;

import com.hand.api.service.FilmService;
import com.hand.infra.dataobject.FilmDO;
import com.hand.infra.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private FilmService filmService;

    @GetMapping("/")
    public void List(Page page) {
        filmService.getByPage(page).forEach(target ->
                logger.error("film:{}", target));

    }

    @PutMapping("/add")
    public void addFilm(@RequestBody FilmDO filmDO){
        filmService.create(filmDO);
        logger.error("add film:{}",filmDO);
    }
}
