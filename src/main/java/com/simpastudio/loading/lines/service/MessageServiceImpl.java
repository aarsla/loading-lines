package com.simpastudio.loading.lines.service;

import com.simpastudio.loading.lines.data.model.internal.SimCity;
import com.simpastudio.loading.lines.data.repository.AdjectiveRepository;
import com.simpastudio.loading.lines.data.repository.NounRepository;
import com.simpastudio.loading.lines.data.repository.SimCityRepository;
import com.simpastudio.loading.lines.data.model.Message;
import com.simpastudio.loading.lines.data.repository.VerbRepository;
import com.simpastudio.loading.service.CounterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class MessageServiceImpl implements MessageService {

    private CounterService counterService;
    private AdjectiveRepository adjectiveRepository;
    private VerbRepository verbRepository;
    private NounRepository nounRepository;
    private SimCityRepository simCityRepository;

    public MessageServiceImpl(CounterService counterService, AdjectiveRepository adjectiveRepository, VerbRepository verbRepository, NounRepository nounRepository, SimCityRepository simCityRepository) {
        this.counterService = counterService;
        this.adjectiveRepository = adjectiveRepository;
        this.verbRepository = verbRepository;
        this.nounRepository = nounRepository;
        this.simCityRepository = simCityRepository;
    }

    @Override
    public Message getMessage() {
        counterService.incrementAndGetMessageCounter();
        return new Message().builder().message(message()).build();
    }

    @Override
    public List<Message> getMessages(int limit) {
        return messages(limit);
    }

    @Override
    public Message getShortMessage() {
        counterService.incrementAndGetMessageCounter();
        return new Message().builder().message(shortMessage()).build();
    }

    @Override
    public List<Message> getShortMessages(int limit) {
        return shortMessages(limit);
    }

    @Override
    public Message getSimCityMessage() {
        counterService.incrementAndGetMessageCounter();
        return new Message().builder().message(simCityMessage().getMessage()).build();
    }

    @Override
    public List<Message> getSimCityMessages(int limit) {
        return simCityMessages(limit);
    }

    @Override
    public String getAdjective() {
        return adjectiveRepository.random().getAdjective();
    }

    @Override
    public String getVerb() {
        return verbRepository.random().getVerb();
    }

    @Override
    public String getNoun() {
        return nounRepository.random().getNoun();
    }

    private String message() {
        return getVerb() + " " + getAdjective() + " " + getNoun();
    }

    private List<Message> messages(int number) {
        ArrayList<Message> results = new ArrayList<>();

        IntStream.rangeClosed(1, number)
                .forEach(i -> {
                    counterService.incrementAndGetMessageCounter();
                    results.add(Message.builder().message(message()).build());
                });

        return results;
    }

    private String shortMessage() {
        return getVerb() + " " + getNoun();
    }

    private List<Message> shortMessages(int number) {
        ArrayList<Message> results = new ArrayList<>();

        IntStream.rangeClosed(1, number)
                .forEach(i -> {
                    counterService.incrementAndGetMessageCounter();
                    results.add(Message.builder().message(shortMessage()).build());
                });

        return results;
    }

    private SimCity simCityMessage() {
        counterService.incrementAndGetMessageCounter();
        return simCityRepository.random();
    }

    private List<Message> simCityMessages(int number) {
        ArrayList<Message> results = new ArrayList<>();

        IntStream.rangeClosed(1, number)
                .forEach(i -> {
                    counterService.incrementAndGetMessageCounter();
                    results.add(Message.builder().message(simCityMessage().toString()).build());
                });

        return results;
    }
}

