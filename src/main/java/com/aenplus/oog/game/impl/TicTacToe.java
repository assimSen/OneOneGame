package com.aenplus.oog.game.impl;

import java.util.ArrayList;
import java.util.List;

import com.aenplus.oog.entity.Player;
import com.aenplus.oog.game.Game;
import com.aenplus.oog.table.Cell;
import com.aenplus.oog.table.Table;

public class TicTacToe extends Game implements Cloneable {
	
	public void initGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		table = new Table(3, 3);
		lastPlayer = player2;
	}
	
	public boolean isFinished() {
		if (table.isFull())
			return true;
		return isWinner();
	}

	public boolean isWinner(){
		List<Cell> cells = table.getCells();
		if (
				   (cells.get(0).getPlayer() == cells.get(1).getPlayer() && cells.get(1).getPlayer() == cells.get(2).getPlayer() && cells.get(0).getPlayer() != null)
				|| (cells.get(3).getPlayer() == cells.get(4).getPlayer() && cells.get(4).getPlayer() == cells.get(5).getPlayer() && cells.get(3).getPlayer() != null)
				|| (cells.get(6).getPlayer() == cells.get(7).getPlayer() && cells.get(7).getPlayer() == cells.get(8).getPlayer() && cells.get(6).getPlayer() != null)
				|| (cells.get(0).getPlayer() == cells.get(3).getPlayer() && cells.get(3).getPlayer() == cells.get(6).getPlayer() && cells.get(0).getPlayer() != null)
				|| (cells.get(1).getPlayer() == cells.get(4).getPlayer() && cells.get(4).getPlayer() == cells.get(7).getPlayer() && cells.get(1).getPlayer() != null)
				|| (cells.get(2).getPlayer() == cells.get(5).getPlayer() && cells.get(5).getPlayer() == cells.get(8).getPlayer() && cells.get(2).getPlayer() != null)
				|| (cells.get(0).getPlayer() == cells.get(4).getPlayer() && cells.get(4).getPlayer() == cells.get(8).getPlayer() && cells.get(0).getPlayer() != null)
				|| (cells.get(2).getPlayer() == cells.get(4).getPlayer() && cells.get(4).getPlayer() == cells.get(6).getPlayer() && cells.get(2).getPlayer() != null)) {
				return true;
			}
			return false;
	}
	public Player getWinner() {
		if (this.isWinner())
			return lastPlayer;
		else
			return null;
	}

	public List<Game> possibleMoves() {
		Player player = this.mustPlay();
		List<Game> possibleMoves = new ArrayList<Game>();
		List<Cell> currentCells = table.getCells();
		for (int i = 0; i < currentCells.size(); i++) {
			if (currentCells.get(i).isEmpty()) {
				Game newGame = this.clone();
				newGame.getTable().getCells().get(i).setPlayer(player);
				newGame.setLastPlayer(player);
				possibleMoves.add(newGame);
			}
		}
		return possibleMoves;
	}
}
