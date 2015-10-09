package com.spring.contacts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.contacts.model.Player;

/**
 * 
 * @author Naresh Podichetty
 *
 */
@Repository
public class PlayerDAOImpl implements PlayerDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PlayerDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPlayer(Player p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Player saved successfully, Player Details = " + p);
	}

	@Override
	public void updatePlayer(Player p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Player updated successfully, Player Details = " + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> listPlayers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Player> playersList = session.createQuery("from Player").list();
		for(Player p : playersList){
			logger.info("Player List::"+p);
		}
		return playersList;
	}

	@Override
	public Player getPlayerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Player p = (Player) session.load(Player.class, new Integer(id));
		logger.info("Player loaded successfully, Player details="+p);
		return p;
	}

	@Override
	public void removePlayer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Player p = (Player) session.load(Player.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Player deleted successfully, player details = " + p);
	}

}
