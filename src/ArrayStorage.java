import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
Resume[] storage = new Resume[ 10000 ];

void clear () {
    for (int i = 0; i < storage.length; i++) {
        if (storage[ i ] != null) {
            storage[ i ] = null;
        }
    }
}

void save (Resume r) {

}
Resume get (String uuid) {
    for (Resume resume : storage) {
        if (Objects.equals (uuid, resume.uuid)) {
            return resume;
        }
    }
    return null;
}

void delete (String uuid) {

    }

/**
 * @return array, contains only Resumes in storage (without null)
 */
Resume[] getAll () {
    return new Resume[0];
    }
int size () {
    return storage.length;
    }
}
