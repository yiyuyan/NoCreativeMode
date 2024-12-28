package cn.ksmcbrigade.sl;

import cn.ksmcbrigade.sl.utils.ModConfigEx;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.slf4j.Logger;

@Mod(StrongLuck.MOD_ID)
public class StrongLuck
{
    public static final String MOD_ID = "sl";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.DoubleValue luck = BUILDER.defineInRange("luck",122d,-255d,255d);
    private static final ModConfigSpec.DoubleValue loot_luck = BUILDER.defineInRange("loot_luck",10d,-255d,255d);
    private static final ModConfigSpec.IntValue rolls = BUILDER.defineInRange("rolls",10,-10,1000);
    private static final ModConfigSpec config = BUILDER.build();

    public static final ModConfigEx<Double> LUCK = new ModConfigEx<>(config, luck);
    public static final ModConfigEx<Double> LOOT_LUCK = new ModConfigEx<>(config, loot_luck);
    public static final ModConfigEx<Integer> ROLLS = new ModConfigEx<>(config, rolls);

    public StrongLuck(IEventBus modEventBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.COMMON,config);
        LOGGER.info("Strong Luck mod loaded.");

    }
}
