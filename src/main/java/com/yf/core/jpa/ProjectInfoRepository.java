package com.yf.core.jpa;

import com.yf.core.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;

/**
* Created by if on 2017/11/22.
*/
@Repository
public interface ProjectInfoRepository extends JpaRepository<ProjectInfo, String>{

	
}

