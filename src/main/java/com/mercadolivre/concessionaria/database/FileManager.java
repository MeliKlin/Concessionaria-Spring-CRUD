package com.mercadolivre.concessionaria.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolivre.concessionaria.exceptions.ReadDatabaseException;
import com.mercadolivre.concessionaria.exceptions.WriteDatabaseException;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;

public class FileManager<T> {

    private final ObjectMapper objectMapper;

    @Value("path.database.file")
    private String databasePath;

    public FileManager() {
        this.objectMapper = new ObjectMapper();
    }

    public void write(String filename, String contentToBeSaved) throws WriteDatabaseException {

        String filePath = databasePath.concat(filename);

        try {
            objectMapper.writeValue(new File(filePath), contentToBeSaved);
        } catch (IOException err) {
            throw new WriteDatabaseException("Something went wrong when trying to write on file.\nStack Trace message:".concat(err.getMessage()));
        }

    }

    public T read(String filename, Class<T> typeParameterClass) throws ReadDatabaseException{

        String filePath = databasePath.concat(filename);

        try {
            return objectMapper.readValue(new File(filePath), typeParameterClass);
        } catch (SecurityException err) {
            throw new ReadDatabaseException("Check the file read permission.\nStack Trace message:".concat(err.getMessage()));
        } catch (IOException err) {
            throw new ReadDatabaseException("Something went wrong when trying to read the file.\nStack Trace message:".concat(err.getMessage()));
        }

    }

}
