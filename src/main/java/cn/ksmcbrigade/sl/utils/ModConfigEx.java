package cn.ksmcbrigade.sl.utils;

import net.neoforged.neoforge.common.ModConfigSpec;

public record ModConfigEx<T>(ModConfigSpec config,ModConfigSpec.ConfigValue<T> value) {
    public T getValue(){
        return config.isLoaded()?value.get():value.getDefault();
    }
}
