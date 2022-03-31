package com.mofec.parkour;

import org.bukkit.ChatColor;

import javax.annotation.Nonnull;
import java.text.SimpleDateFormat;
import java.util.Objects;

public final class Util {

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

    /**
     * 获取并替换复杂的颜色格式化代码
     * @param string 配置文件路径或需处理的字符串
     * @param isAPath 是否为文件路径
     * @return 颜色格式化代码替换后的字符串
     */
    @Nonnull
    public static String getAndTranslate(@Nonnull String string, boolean isAPath) {
        if (isAPath) {
            String str = Objects.requireNonNull(ParkourTimer.instance.getConfig().getString(string, ""));
            return ChatColor.translateAlternateColorCodes('&', str);
        } else {
            return ChatColor.translateAlternateColorCodes('&', string);
        }
    }



    @Nonnull
    public static String patternReplace1ForTime(@Nonnull String path, String data) {
        String str = Objects.requireNonNull(ParkourTimer.instance.getConfig().getString(path, ""));
        return str.replaceAll("\\$\\{time}", data);
    }

    @Nonnull
    public static String patternReplace2ForTime(@Nonnull String path, String data, String data2) {
        String str = Objects.requireNonNull(ParkourTimer.instance.getConfig().getString(path, ""));
        str = str.replaceAll("\\$\\{time1}", data);
        String result = str.replaceAll("\\$\\{time2}", data2);
        return result;
    }

    @Nonnull
    public static String patternReplaceForCheckpointNO(@Nonnull String path, int numberOrder) {
        String str = Objects.requireNonNull(ParkourTimer.instance.getConfig().getString(path, ""));
        str = str.replaceAll("\\$\\{pointNo}", Integer.toString(numberOrder));
        return str;

    }
}
