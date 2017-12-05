package com.yf.sys.jpa;


import com.yf.sys.entity.SysDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by if on 2017/11/22.
 */
@Repository
public interface SysDictRepository extends JpaRepository<SysDict, String> {
    SysDict findTop1ByKeyAndType(String key, String type);
    List<SysDict> findByType(String type);
}

