package com.simpastudio.loading.lines.service;

import com.simpastudio.loading.lines.data.model.Message;

import java.util.List;

public interface MessageService {
    Message getMessage();
    List<Message> getMessages(int limit);

    Message getShortMessage();
    List<Message> getShortMessages(int limit);

    Message getSimCityMessage();
    List<Message> getSimCityMessages(int limit);

    String getAdjective();
    String getVerb();
    String getNoun();
}
