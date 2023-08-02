package by.academypvt.repository;

import java.io.*;

public abstract class FileWorker implements Serializable {


    @Serial
    private static final long serialVersionUID = -7994607932307928487L;

    public Object deserializeObject(String PATH) {
        Object object = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATH))) {
            object = objectInputStream.readObject();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return object;
    }

    public void serializeObject(Object object, String PATH) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            objectOutputStream.writeObject(object);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
