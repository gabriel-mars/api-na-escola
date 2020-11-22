package com.gabriel.martins.apinaescola.model.utils;

import java.util.List;

public interface IService <Entity>{
    public Object initializeLazyList(String listName, Long id, Class c);

    public void save(Object entity) throws Exception;

    public void save(List entities) throws Exception;

    public void update(Object entity) throws Exception;

    public void update(List<? extends Object> entities);

    public void remove(Object entity, Long id) throws Exception;

    public void remove(Class clazz, List<Long> ids) throws Exception;

    public Object findLastEntry(Class clazz);

    public Entity findLastEntry();

    public boolean verifyLazyList(Object object);

    public Entity findById(Long id);
}
