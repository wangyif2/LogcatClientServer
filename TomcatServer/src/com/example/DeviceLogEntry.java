package com.example;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ywang
 * Date: 25/05/12
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class DeviceLogEntry {
    private final String contents;
    private final Date timestamp;

    public DeviceLogEntry(String contents, Date timestamp) {
        this.contents = contents;
        this.timestamp = timestamp;
    }

    public String getContents() {
        return contents;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceLogEntry that = (DeviceLogEntry) o;

        if (contents != null ? !contents.equals(that.contents) : that.contents != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contents != null ? contents.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceLogEntry{" +
                "contents='" + contents + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
