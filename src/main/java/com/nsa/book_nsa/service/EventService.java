package com.nsa.book_nsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsa.book_nsa.model.Event;
import com.nsa.book_nsa.repository.EventRepository;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Optional<Event> existingEvent = eventRepository.findById(id);

        if (existingEvent.isPresent()) {
            Event event = existingEvent.get();
            event.setName(updatedEvent.getName());
            event.setUserId(updatedEvent.getUserId());
            event.setDate(updatedEvent.getDate());
            event.setTimeStart(updatedEvent.getTimeStart());
            event.setTimeEnd(updatedEvent.getTimeEnd());
            event.setCity(updatedEvent.getCity());
            event.setPlace(updatedEvent.getPlace());
            event.setAuthorId(updatedEvent.getAuthorId());
            return eventRepository.save(event);
        } else {
            throw new RuntimeException("Événement introuvable avec l'ID : " + id);
        }
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
