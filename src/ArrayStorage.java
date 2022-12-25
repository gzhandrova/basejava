import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
Resume[] storage = new Resume[ 10000 ];
private int count = 0;

void clear () {
    
    Arrays.fill (storage, 0, count, null); count = 0;
}

void save (Resume r) {
    storage[ count ] = r; count++;
}

Resume get (String uuid) {
    for (int i = 0; i < count; i++) {
        if (Objects.equals (uuid, storage[ i ].getUuid ())) {
            int uid = i; return storage[ uid ];
        }
    } return null;
}

void delete (String uuid) {
    for (int i = 0; i < count; i++) {
        if (Objects.equals (uuid, storage[ i ].getUuid ())) {
            storage[ i ] = storage[ count - 1 ]; storage[ count - 1 ] = null; count--; break;
            
        }
    }
}

/**
 * @return array, contains only Resumes in storage (without null)
 */
Resume[] getAll () {
    Resume[] allResume = new Resume[ count ];
    System.arraycopy (storage, 0, allResume, 0, count); return allResume;
}

int size () {
    return count;
}
}

