package com.spring.contacts.dao;

import java.util.List;

import com.spring.contacts.model.Player;

/**
 * 
 * @author Naresh Podichetty
 *
 */
public interface PlayerDAO {

	public void addPlayer(Player p);
	
	public void updatePlayer(Player p);
	
	public List<Player> listPlayers();
	
	public Player getPlayerById(int id);
	
	public void removePlayer(int id);
}
