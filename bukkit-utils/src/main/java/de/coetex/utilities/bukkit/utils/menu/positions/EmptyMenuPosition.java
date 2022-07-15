package de.coetex.utilities.bukkit.utils.menu.positions;

import de.coetex.utilities.bukkit.utils.animation.SoundSample;
import de.coetex.utilities.bukkit.utils.menu.MenuClickInfo;
import de.coetex.utilities.bukkit.utils.menu.MenuPosition;

import javax.annotation.Nonnull;


public class EmptyMenuPosition implements MenuPosition {

	@Override
	public void handleClick(@Nonnull MenuClickInfo info) {
		SoundSample.CLICK.play(info.getPlayer());
	}

}
