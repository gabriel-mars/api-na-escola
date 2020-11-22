package com.gabriel.martins.apinaescola.model.utils;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManager;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import java.io.Serializable;
import java.util.List;

public class GenericPersistence implements Serializable {
    @PreDestroy
    public void preDestroy() {
        System.out.println("INFO: " + "@PreDestroy");
    }

    //--------------------------------------------------------------------------
    //Atributos
    //--------------------------------------------------------------------------
    @PersistenceUnit(unitName = "base_PU")
    private EntityManagerFactory entityManagerFactory;
    private Session session;

    //--------------------------------------------------------------------------
    //Métodos
    //--------------------------------------------------------------------------
    public void merge(Object entity) throws NotSupportedException, SystemException, org.hibernate.exception.ConstraintViolationException, IllegalStateException,
            PersistenceException, HibernateException {
        EntityManager entityManager = createEntityManager();
        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            entityManager.flush();
        }
    }

    public void merge(List<? extends Object> entities) throws NotSupportedException, SystemException, org.hibernate.exception.ConstraintViolationException, IllegalStateException,
            PersistenceException, HibernateException {
        EntityManager entityManager = createEntityManager();
        try {
            for (Object o : entities) {
                entityManager.merge(o);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            entityManager.flush();
        }
    }

    public void persist(Object entity) throws NotSupportedException, SystemException, org.hibernate.exception.ConstraintViolationException, IllegalStateException,
            PersistenceException, HibernateException {
        EntityManager entityManager = createEntityManager();
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            entityManager.flush();
        }
    }

    public void persist(List<? extends Object> entities) throws NotSupportedException, SystemException, org.hibernate.exception.ConstraintViolationException, IllegalStateException,
            PersistenceException, HibernateException {
        EntityManager entityManager = createEntityManager();
        try {
            for (Object o : entities) {
                entityManager.persist(o);
            }
        } finally {
            entityManager.flush();
        }
    }

    public void detach(Object entity) {
        EntityManager entityManager = createEntityManager();

        try {
            entityManager.detach(entity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            entityManager.flush();
        }
    }

    public void detach(List<? extends Object> entities) {
        EntityManager entityManager = createEntityManager();

        try {
            for (Object o : entities) {
                entityManager.detach(o);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            entityManager.flush();
        }
    }

    public Criteria createCriteria(Class classe) {
        return getSession().createCriteria(classe);
    }

    public void remove(Object entity, Object id) throws Exception {
        EntityManager entityManager = createEntityManager();
        try {
            entity = entityManager.find(entity.getClass(), id);
            entityManager.remove(entity);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (TransactionRequiredException e) {
            e.printStackTrace();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                entityManager.flush();
            } catch (Exception e2) {
                e2.printStackTrace();
                throw e2;
            }
        }
    }

    public void remove(Class claz, List<Long> entities) throws Exception {
        EntityManager entityManager = createEntityManager();
        try {
            for (Long id : entities) {
                Object o = entityManager.find(claz, id);
                entityManager.remove(o);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (TransactionRequiredException e) {
            e.printStackTrace();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                entityManager.flush();
            } catch (Exception e2) {
                e2.printStackTrace();
                throw e2;
            }
        }
    }

    public void deletePersistMerge(List<? extends Object> deleteEntities,
                                   List<? extends Object> persistEntities, List<? extends Object> mergeEntities) throws Exception {
        EntityManager entityManager = createEntityManager();
        try {

            if (deleteEntities != null) {
                for (Object o : deleteEntities) {
                    Object objAux = null;
                    try {
                        objAux = entityManager.find(o.getClass(), o.getClass().getDeclaredMethod("getId").invoke(o));
                    } catch (Exception e) {
                        throw new Exception("A classe " + o.getClass() + " deve possuir um método getId() que retorna o id do objeto no banco");
                    }
                    entityManager.remove(objAux);
                }
            }

            if (persistEntities != null) {
                for (Object o : persistEntities) {
                    entityManager.persist(o);
                }
            }

            if (mergeEntities != null) {
                for (Object o : mergeEntities) {
                    entityManager.merge(o);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                entityManager.flush();
            } catch (Exception e2) {
                e2.printStackTrace();
                throw e2;
            }
        }

    }

    public Object runQuery(String query) throws HibernateException {

        try {
            Object result = getSession().createSQLQuery(query).uniqueResult();
            return result;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            try {
                clearSession();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
        return null;
    }

    /**
     * @descrição: Executa um comando SQL no banco. Não é usado para consultas
     * (não retorna resultados), apenas para comandos de update, delete...
     */
    public void executeQuery(String query) throws HibernateException {

        try {
            getSession().createSQLQuery(query).executeUpdate();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            try {
                clearSession();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }

    public List runSQLQuery(String query) throws HibernateException {
        try {
            return getSession().createSQLQuery(query).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            try {
                clearSession();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
        return null;
    }

    public SQLQuery createSQLQuery(String query) {
        return getSession().createSQLQuery(query);
    }

    public List runSQLQuery(SQLQuery query) {
        try {
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            try {
                clearSession();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
        return null;
    }

    public void executeSQLQuery(SQLQuery query) {
        try {
            query.executeUpdate();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            try {
                clearSession();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }

    public void clearSession() throws Exception {
        if (session != null) {
            session.flush();
            session.clear();
        }
    }

    //--------------------------------------------------------------------------
    //Getters e Setters
    //--------------------------------------------------------------------------
    public Session getSession() {
        EntityManager entityManager = createEntityManager();
        HibernateEntityManager hem = entityManager.unwrap(HibernateEntityManager.class);
        session = hem.getSession();
        return session;
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
