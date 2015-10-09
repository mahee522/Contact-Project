package com.spring.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.contacts.model.Player;
import com.spring.contacts.service.PlayerService;

/**
 * The main heart of the application
 * 
 * @author Naresh Podichetty
 *
 */
@Controller
public class PlayerController {
	
	private PlayerService playerService;
	
	/**
	 * 
	 * @param playerService
	 */
	@Autowired(required = true)
	@Qualifier(value = "playerService")
	public void setPlayerService(PlayerService playerService){
		this.playerService = playerService;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public String listPlayers(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("listPlayers", this.playerService.listPlayers());
		return "player";
	}
	
	/**
	 * To add / update player
	 * 
	 * @param player
	 * @return
	 */
	@RequestMapping(value = "/player/add", method = RequestMethod.POST)
	public String addPlayer(@ModelAttribute("player") Player player){
		
		if(player.getId() == 0) { // If the Player is new, then add him
			this.playerService.addPlayer(player);
		} else { //If the Player is an existing player, then update
			this.playerService.updatePlayer(player);
		}
		return "redirect:/players";
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove/{id}")
    public String removePlayer(@PathVariable("id") int id) {
        this.playerService.removePlayer(id);
        return "redirect:/players";
    }
 
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
    @RequestMapping("/edit/{id}")
    public String editPlayer(@PathVariable("id") int id, Model model) {
        model.addAttribute("player", this.playerService.getPlayerById(id));
        model.addAttribute("listPlayers", this.playerService.listPlayers());
        return "player";
    }
}
