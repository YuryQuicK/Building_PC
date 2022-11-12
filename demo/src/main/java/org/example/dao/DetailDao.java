package org.example.dao;

import org.example.models.Detail;
import org.example.utils.HibernateSessionFactoryUtil;
import javax.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class DetailDao {

    public List<Detail> findByName(String detailName) {
        return (List<Detail>) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("from Detail where name = " + detailName).list();
    }
}
