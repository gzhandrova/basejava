package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
   private Resume[] storage = new Resume[10000];
   private int count = 0;
   
   public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }
    
    public void update(Resume r) {
        int indexOfResume = foundIndex (r.getUuid ());
        if(indexOfResume == -1) {
            printError ();
        } else {
            storage[indexOfResume] = r;
        }
    }
    
   public void save(Resume r) {
       if (foundIndex(r.getUuid()) != -1 || count >= storage.length) {
           System.out.println("Resume is exist!");
       } else {
           storage[count] = r;
           count++;
       }
   }
   
   public Resume get(String uuid) {
       int indexOfResume = foundIndex(uuid);
       if(indexOfResume == -1) {
           printError();
           return null;
       }
       return storage[indexOfResume];
   }
   
   public void delete(String uuid) {
       int indexOfResume = foundIndex(uuid);
       if(indexOfResume == -1) {
           printError();
       } else {
           storage[indexOfResume] = storage[count-1];
           storage[count-1] = null;
           count--;
       }
    }
    
   public Resume[] getAll() {
        Resume[] allResume = new Resume[count];
        System.arraycopy (storage, 0, allResume, 0, count);
        return allResume;
    }
    
   public int size() {
        return count;
    }
    
    private int foundIndex(String uuid) {
        for(int i = 0; i < count; i++) {
            if(Objects.equals(uuid,storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
    
    private void printError() {
        System.out.println("Resume is not exist!");
    }
}