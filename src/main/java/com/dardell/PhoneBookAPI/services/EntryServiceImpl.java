package com.dardell.PhoneBookAPI.services;

import com.dardell.PhoneBookAPI.utility.DateFormatter;
import com.dardell.PhoneBookAPI.services.entity.EntryEntity;
import com.dardell.PhoneBookAPI.model.Entry;
import com.dardell.PhoneBookAPI.repository.EntryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryServiceImpl implements EntryService {

    private final EntryRepository entryRepository;

    public EntryServiceImpl(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @Override
    public Entry createEntry(Entry entry) {
            EntryEntity entryEntity = new EntryEntity();

        BeanUtils.copyProperties(entry, entryEntity);
        entryRepository.save(entryEntity);
        return entry;
    }

    @Override
    public List<Entry> getAllEntries() {
        List<EntryEntity> entryEntities
                = entryRepository.findAll();

        List<Entry> entries = entryEntities
                .stream()
                .map(ent -> new Entry(ent.getId(), ent.getName(),
                        ent.getPhoneNumber(), ent.getDate(), ent.getAsyncString()))
                .collect(Collectors.toList());
        return entries;
    }
    @Override
    public boolean deleteEntry(Long id) {
        EntryEntity entry = entryRepository.findById(id).get();
        entryRepository.delete(entry);
        return true;
    }
    @Override
    public Entry getEntryById(Long id) {
        EntryEntity entryEntity
                = entryRepository.findById(id).get();
        Entry entry = new Entry();
        BeanUtils.copyProperties(entryEntity, entry);
        return entry;
    }

    @Override
    public Entry updateEntry(Long id, Entry entry) {
        EntryEntity entryEntity
                = entryRepository.findById(id).get();
        entryEntity.setName(entry.getName());
        entryEntity.setPhoneNumber(entry.getPhoneNumber());
        if (!entry.getDate().equals("keepTheDate")) {
            entryEntity.setDate(DateFormatter.getFormattedDate());}
        entryEntity.setAsyncString(entry.getAsyncString());
        entryRepository.save(entryEntity);
        return entry;
    }
}
