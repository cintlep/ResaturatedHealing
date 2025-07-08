package cintlex.rh;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResaturatedHealing implements ModInitializer {
	public static final String MOD_ID = "resaturated-healing";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Resaturated Healing loaded");
	}
}