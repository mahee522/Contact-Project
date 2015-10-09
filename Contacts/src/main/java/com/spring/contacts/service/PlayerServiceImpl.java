package com.spring.contacts.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.contacts.dao.PlayerDAO;
import com.spring.contacts.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private PlayerDAO playerDAO;

	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}

	@Override
	@Transactional
	public void addPlayer(Player p) {
		this.playerDAO.addPlayer(p);
	}

	@Override
	@Transactional
	public void updatePlayer(Player p) {
		this.playerDAO.updatePlayer(p);
	}

	@Override
	@Transactional
	public List<Player> listPlayers() {
		return this.playerDAO.listPlayers();
	}

	@Override
	@Transactional
	public Player getPlayerById(int id) {
		return this.playerDAO.getPlayerById(id);
	}

	@Override
	@Transactional
	public void removePlayer(int id) {
		this.playerDAO.removePlayer(id);
	}

}
