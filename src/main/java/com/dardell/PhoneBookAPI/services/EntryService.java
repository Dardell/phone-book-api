package com.dardell.PhoneBookAPI.services;

import com.dardell.PhoneBookAPI.model.Entry;

import java.util.List;

public interface EntryService {

    Entry createEntry(Entry entry);

    List<Entry> getAllEntries();

    boolean deleteEntry(Long id);

    Entry getEntryById(Long id);

    Entry updateEntry(Long id, Entry entry);
}
