package com.hand.api.service;

import java.util.List;

import com.hand.infra.dataobject.FilmDO;
import com.hand.infra.util.Page;

public interface FilmService {

    int create(FilmDO filmDO);

    List<FilmDO> getByPage(Page page);

    FilmDO getById(Integer id);
}
