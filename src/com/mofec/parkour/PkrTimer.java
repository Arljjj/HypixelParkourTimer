package com.mofec.parkour;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.*;

public class PkrTimer {
    //TODO 编写计时代码,时间存储代码
    private static List<UUID> onParkouring = new ArrayList<>();
    private static Map<UUID, Long> startTimeList = new HashMap<>();
    private static Map<UUID, Long> timeList = new HashMap<>();
    //创建启动时间
    public static void createStartTime(UUID id) {
        Long time = System.currentTimeMillis();
        if (!onParkouring.contains(id)) {
            onParkouring.add(id);
            startTimeList.put(id, time);
        } else {
            startTimeList.remove(id);
            startTimeList.put(id, time);
            Bukkit.getPlayer(id).sendMessage(Util.getAndTranslate("msg.time-reset"));
        }
    }

    //创建结束时间并返回格式化的时间间隔
    public static long createAndReturnEndtime(UUID id) {
        if (!onParkouring.contains(id)) {
            return 0;
        } else {
            long time1 = startTimeList.get(id);
            long time2 = System.currentTimeMillis();
            long timeResult = time2 - time1;
            onParkouring.remove(id);
            startTimeList.remove(id);
            timeList.put(id, timeResult);
            return timeResult;
        }
    }
}
