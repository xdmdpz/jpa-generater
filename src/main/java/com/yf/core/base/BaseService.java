package com.yf.core.base;

import com.yf.uitls.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
* Created by if on 2017/11/22.
* @author sunyifu
*/
@Service
@Transactional(readOnly = true ,rollbackFor= Exception.class)
public abstract class BaseService<T extends BaseEntity,R extends JpaRepository<T,ID> ,ID extends Serializable> {

	@Autowired
	private R repository;

	/**
	 * 新增
	 *
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void create(T entity) {
		repository.save(entity);

	}

	/**
	 * 更新
	 *
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void update(T entity) {
		T update = repository.findOne((ID) entity.id);
		BeanUtils.copyProperties(entity, update, new String[]{"id","createTime", "delTag"});
		repository.saveAndFlush(update);
	}

	/**
	* 删除
	* @param entity
	*/
	@Transactional(readOnly = false)
	public void delete(T entity) {
		entity.setDelTag("1");
		repository.saveAndFlush(entity);
	}

	/**
	* 通过主键查找
	* @param id
	* @return
	*/
	public T findByid(ID id) {
		return (T) repository.findOne(id);
	}

	/**
	* 查询所有（排序）
	* @param sort 排序
	* @return
	*/
	public List<T> findList(Sort sort) {
    	return repository.findAll(sort);
	}

    /**
    * 查询所有(分页)
    * @param pageable 分页
    * @return
    */
    public Page<T> findPage(Pageable pageable){
        return  repository.findAll(pageable);
        }


}