package com.comp373.model.human;

import com.comp373.model.building.BattleDome;

public interface Manager extends Human{

	public void setBattleDome(BattleDome newDome);

	public BattleDome getBattleDome();

}
