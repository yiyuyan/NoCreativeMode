package cn.ksmcbrigade.ncm;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(NoCreativeMode.MOD_ID)
public class NoCreativeMode
{
    public static final String MOD_ID = "ncm";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NoCreativeMode(IEventBus modEventBus, ModContainer modContainer)
    {
        LOGGER.info("No Creative Mode mod loaded.");
    }
}
