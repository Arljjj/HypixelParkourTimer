package com.mofec.parkour;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class ParkourTimer extends JavaPlugin {
    public static JavaPlugin instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        if (Bukkit.getPluginCommand("parkour") != null) {
            Objects.requireNonNull(Bukkit.getPluginCommand("parkour")).setExecutor(new Commander());
        }
    }
}
