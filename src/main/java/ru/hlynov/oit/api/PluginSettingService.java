package ru.hlynov.oit.api;

public interface PluginSettingService {
    String getConfigJson();
    void setConfigJson(String json);
}
