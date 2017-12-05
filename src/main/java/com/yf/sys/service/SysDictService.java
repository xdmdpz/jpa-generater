package com.yf.sys.service;



import com.yf.core.base.BaseService;
import com.yf.sys.entity.SysDict;
import com.yf.sys.jpa.SysDictRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by if on 2017/11/22.
 *
 * @author sunyifu
 */
@Service
@Transactional(readOnly = true)
public class SysDictService extends BaseService<SysDict, SysDictRepository, String> {
    public List<SysDict> getDictsByType(String type) {
        return repository.findByType(type);
    }

    public SysDict getDictByKeyAndType(String key, String type) {
        return repository.findTop1ByKeyAndType(key, type);
    }
}