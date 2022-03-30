package com.mofec.parkour;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.libs.jline.internal.Nullable;

import javax.annotation.Nonnull;
import java.util.Objects;

public final class Util {

    @Nonnull
    public static String getAndTranslate(@Nonnull String path) {
        String str = Objects.requireNonNull(ParkourTimer.instance.getConfig().getString(path, ""));
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    //TODO 创建时间格式化代码
    @Nullable
    public static String timeToString(long time) {
        if (time == 0) {
           return "00:00:00.000";
        }
        return "";
    }
}
