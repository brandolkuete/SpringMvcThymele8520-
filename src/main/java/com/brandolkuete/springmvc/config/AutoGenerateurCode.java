package com.brandolkuete.springmvc.config;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

public class AutoGenerateurCode implements Serializable {

    private static String pathDirectorySaveState = "src/main/java/com/brandolkuete/springmvc/config/autoGenerate/";
    private static String nameFileSave = "state_generator_code";

    /**
     * Cette methode prend en entrée une instance de classe
     * @param t Object
     * @return une Séquence unique
     */
    public static String generateSequence(Object t) {
        return t.getClass().getSimpleName().toUpperCase() +
                Math.abs(t.hashCode()) +
                saveStateSequenceGenerator(
                        new AtomicLong(
                                loadStateSequenceGenerator()
                        ).incrementAndGet()
                );
    }

    private static long saveStateSequenceGenerator(long s){
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream( pathDirectorySaveState + nameFileSave)));
            dataOutputStream.writeLong(s);
            dataOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    private static long loadStateSequenceGenerator(){
        DataInputStream dataInputStream;
        long result = 0L;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(pathDirectorySaveState + nameFileSave)));
            result = dataInputStream.readLong();
            dataInputStream.close();
        } catch (FileNotFoundException e){
            File file = new File(pathDirectorySaveState);
            if (!file.isDirectory()){
                file.mkdirs();
            }
            new File(file + nameFileSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
