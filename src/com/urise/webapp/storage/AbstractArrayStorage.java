package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;
    
    public int size() {
        return count;
    }

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void update(Resume r) {
        int index = findIndex(r.getUuid());
        if(index == -1) {
            System.out.println("Resume not found!");
        } else {
            storage[index] = r;
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if(index == -1) {
            System.out.println("Resume not found!");
        } else {
            fillDeletedElement(index);
            storage[count - 1] = null;
            count--;
        }
    }
    
    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if(index >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if(count == STORAGE_LIMIT){
            System.out.println("Storage overflow");
        } else {
            insertElement(r,index);
            count++;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, count);
    }
    
    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if(index == -1) {
            System.out.println("Resume not found!");
            return null;
        }
        return storage[index];
    }
    
    protected abstract int findIndex(String uuid);
    protected abstract void fillDeletedElement(int index);
    
    protected abstract void insertElement(Resume r, int index);
}