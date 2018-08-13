package com.hand.infra.mapper;

import com.hand.infra.dataobject.FilmDO;
import tk.mybatis.mapper.common.Mapper;

public interface FilmMapper extends Mapper<FilmDO> {
    void customInsert(FilmDO filmDO);
}
