package com.mhmd.dribbblenotepad_1.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mhmd.dribbblenotepad_1.data.NoteDatabase;
import com.mhmd.dribbblenotepad_1.data.dao.NoteDao;
import com.mhmd.dribbblenotepad_1.data.model.Note;

import java.util.List;

public class Repository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public Repository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAll();
    }

    public void instert(Note note) {
        new insertNote(noteDao).execute(note);
    }

    public void delete(Note note) {
        new deleteNote(noteDao).execute(note);
    }

    public void update(Note note) {
        new updateNote(noteDao).execute(note);
    }

    public void deleteAll() {
        new deletAllNotes(noteDao).execute();
    }

    private static class insertNote extends AsyncTask<Note, Void, Void> {

        private NoteDao noteDao;

        public insertNote(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class deleteNote extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public deleteNote(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    private static class updateNote extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public updateNote(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.update(notes[0]);
            return null;
        }
    }

    private static class deletAllNotes extends AsyncTask<Void, Void, Void> {
        NoteDao noteDao;

        public deletAllNotes(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAll();
            return null;
        }
    }

}





