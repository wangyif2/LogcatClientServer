package com.example;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ywang
 * Date: 25/05/12
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class LogStorage {
    public static final LogStorage STORAGE = new LogStorage();

    private Map<String, List<DeviceLogEntry>> deviceLogs = new HashMap<String, List<DeviceLogEntry>>();

    public synchronized List<DeviceLogEntry> getRecentLogDevice(String deviceId) {
        return deviceLogs.containsKey(deviceId) ? deviceLogs.get(deviceId) : new ArrayList<DeviceLogEntry>();
    }

    public synchronized void addDeviceLog(String deviceId, String contents) {
        List<DeviceLogEntry> entries;
        if (deviceLogs.containsKey(deviceId)) {
            entries = deviceLogs.get(deviceId);
        } else {
            entries = new ArrayList<DeviceLogEntry>();
            deviceLogs.put(deviceId, entries);
        }

        entries.add(new DeviceLogEntry(contents, new Date()));
    }
}
