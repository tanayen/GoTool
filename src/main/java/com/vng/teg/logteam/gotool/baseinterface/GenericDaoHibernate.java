package com.vng.teg.logteam.gotool.baseinterface;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public abstract class GenericDaoHibernate extends HibernateDaoSupport {

	@Autowired
	public void initSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	protected Session getSession() {
		return super.currentSession();
	}

	public void persist(Object entity) {
		getSession().saveOrUpdate(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}

	public void revise(Object entity) {
		getSession().saveOrUpdate(entity);
	}

	public <T> T getById(Class<T> clazz, Long id) {
		return (T) getSession().createCriteria(clazz).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
