package com.hand.api.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.api.service.FilmService;
import com.hand.infra.dataobject.FilmDO;
import com.hand.infra.mapper.FilmMapper;
import com.hand.infra.util.Page;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    @Resource
    private FilmMapper filmMapper;

    @Override
    public int create(FilmDO filmDO) {
        //filmDO.setLanguageId(Integer.parseInt("1"));
        filmDO.setLastUpdate(new Date());
        filmDO.setLength(4);
        filmDO.setReleaseYear(2018);
        filmDO.setRentalRate(BigDecimal.valueOf(2.99));
        filmDO.setRentalDuration(5);
        filmDO.setReplacementCost(BigDecimal.valueOf(15.99));
        filmMapper.customInsert(filmDO);
        return filmDO.getId();
    }


    @Override
    public List<FilmDO> getByPage(Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize());
        List<FilmDO> filmDOS = filmMapper.selectAll();
        PageInfo<FilmDO> pageInfo = new PageInfo<>(filmDOS);
        return pageInfo.getList();
    }

    @Override
    public FilmDO getById(Integer id) {
        return filmMapper.selectByPrimaryKey(id);
    }
}
