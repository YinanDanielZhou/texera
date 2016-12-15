package edu.uci.ics.textdb.dataflow.sink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import edu.uci.ics.textdb.api.common.ITuple;
import edu.uci.ics.textdb.api.exception.TextDBException;

/**
 * Created by chenli on 5/11/16.
 *
 * This class serializes each tuple from the subtree to a given file.
 */
public class FileSink extends AbstractSink {
    
    @FunctionalInterface
    public static interface TupleToString {
        String convertToString(ITuple tuple);
    }

    private PrintWriter printWriter;
    private final File file;   
    private TupleToString toStringFunction = (tuple -> tuple.toString());
    
    public FileSink(File file) {
        this.file = file;
    }
    
    public void setToStringFunction(TupleToString toStringFunction) {
        this.toStringFunction = toStringFunction;
    }

    @Override
    public void open() throws TextDBException {
        super.open();
        try {
            this.printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new TextDBException("Failed to open file sink", e);
        }
    }

    @Override
    public void close() throws TextDBException {
        if (this.printWriter != null) {
            this.printWriter.close();
        }
        super.close();
    }

    @Override
    protected void processOneTuple(ITuple nextTuple) {
        printWriter.write(toStringFunction.convertToString(nextTuple));
    }
    
    //Overloading this function to implement processing multiple tuples
    protected void processOneTuple(ITuple nextTuple, boolean multiple) {
    	//To Do: need code to process multiple tuples
        printWriter.write(toStringFunction.convertToString(nextTuple));
    }

    
    public File getFile() {
        return this.file;
    }
}
