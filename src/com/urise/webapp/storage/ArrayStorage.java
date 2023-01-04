package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int findIndex(String uuid) {
        for(int i = 0; i < count; i++) {
            if(uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[count] = storage[count-1];
    }
    
    @Override
    protected void insertElement(Resume r, int index) {
        storage[count] = r;
    }
}
