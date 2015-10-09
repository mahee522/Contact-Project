package com.spring.contacts.service;

import java.util.List;

import com.spring.contacts.model.Player;

/**
 * 
 * @author Naresh Podichetty
 *
 */
public interface PlayerService {

	public void addPlayer(Player p);
	
	public void updatePlayer(Player p);
	
	public List<Player> listPlayers();
	
	public Player getPlayerById(int id);
	
	public void removePlayer(int id);
	
}
