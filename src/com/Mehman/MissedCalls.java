package com.Mehman;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;


public class MissedCalls {
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private Map<LocalDateTime, String> storage = new TreeMap<>();

    public void addMissedCall(String phone) {
        storage.put(LocalDateTime.now(), phone);
    }

    public String getStringValue(Contacts contacts) {
        if (storage.isEmpty()) return "Нет пропущенных";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<LocalDateTime, String> missedCall : storage.entrySet()) {
            String phone = missedCall.getValue();
            sb
                    .append(
                            getTimeView(
                                    missedCall.getKey()))
                    .append("\t")
                    .append(
                            (contacts.contains(phone)) ?
                                    contacts.get(phone).getName() :
                                    phone)
                    .append("\n");
        }
        return sb.toString();
    }

    public void clear() {
        storage.clear();
    }

    private String getTimeView(LocalDateTime time) {
        return time.format(DATE_TIME_FORMATTER);
    }
}