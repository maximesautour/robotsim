package fr.tp.robotsim.model.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasChooser;
import fr.tp.inf112.projects.canvas.model.impl.AbstractCanvasPersistenceManager;

public class FileSystemCanvasPersistenceManager extends AbstractCanvasPersistenceManager {

    public FileSystemCanvasPersistenceManager(CanvasChooser canvasChooser) {
        super(canvasChooser);
    }

    @Override
    public void persist(Canvas canvasModel) throws IOException {
        String canvasId = canvasModel.getId();
        
        try (
            FileOutputStream fileOutStream = new FileOutputStream(canvasId);
            ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutStream);
        ) {
            objOutStream.writeObject(canvasModel);
        }
    }
    
    @Override
    public Canvas read(String canvasId) throws IOException {
        try (
            FileInputStream fileInStream = new FileInputStream(canvasId);
            ObjectInputStream objInStream = new ObjectInputStream(fileInStream);
        ) {
            return (Canvas) objInStream.readObject();
        }
        catch (ClassNotFoundException ex) {
            throw new IOException("Cannot find class while reading canvas", ex);
        }
    }
    
    @Override
    public boolean delete(Canvas canvasModel) throws IOException {
        File file = new File(canvasModel.getId());
        return file.delete();
    }
}
