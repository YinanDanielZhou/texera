package edu.uci.ics.textdb.dataflow.neextractor;

import edu.uci.ics.textdb.api.common.*;
import edu.uci.ics.textdb.common.constants.SchemaConstants;
import edu.uci.ics.textdb.common.field.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sam on 16/4/27.
 */
public class NEExtractorTestConstants {


    public static final String SENTENCE ="sentence";

    public static final Attribute SENTENCE_ATTR = new Attribute(SENTENCE, FieldType.TEXT);


    public static final List<Attribute> ATTRIBUTES_ONE_SENTENCE = Arrays.asList(
            SENTENCE_ATTR);

    public static final List<Attribute> ATTRIBUTES_TWO_SENTENCE = Arrays.asList(
            SENTENCE_ATTR,SENTENCE_ATTR);
    public static final Schema SCHEMA_ONE_SENTENCE = new Schema(SENTENCE_ATTR);
    public static final Schema SCHEMA_TWO_SENTENCE = new Schema(SENTENCE_ATTR,SENTENCE_ATTR);




    public static List<ITuple> getTest1Tuple() throws ParseException {
        IField[] fields1 = {new TextField("Microsoft is an organization.")};
        ITuple tuple1 = new DataTuple(SCHEMA_ONE_SENTENCE, fields1);
        return Arrays.asList(tuple1);
    }



    public static List<ITuple> getTest2Tuple() throws ParseException {


        IField [] fields1 = {new TextField("Microsoft, Google and Facebook are organizations.")};
        ITuple tuple1 = new DataTuple(SCHEMA_ONE_SENTENCE, fields1);
        return Arrays.asList(tuple1);
    }

    public static List<ITuple> getTest3Tuple() throws ParseException {

        IField [] fields1 = {new TextField("Microsoft,Google and Facebook are organizations and Donald Trump and Barack Obama are persons.")};
        ITuple tuple1 = new DataTuple(SCHEMA_ONE_SENTENCE, fields1);
        return Arrays.asList(tuple1);
    }

    public static List<ITuple> getTest4Tuple() throws ParseException {

        IField [] fields1 = {new TextField("Microsoft,Google and Facebook are organizations."), new TextField(" Donald Trump and Barack Obama are persons")};
        ITuple tuple1 = new DataTuple(SCHEMA_TWO_SENTENCE, fields1);
        return Arrays.asList(tuple1);
    }


    public static List<ITuple> getTest1ResultTuples() {
        List<ITuple> resultList= new ArrayList<>();
        List<IField> fields = new ArrayList<IField>();
        List<Span> spanList = new ArrayList<Span>();
        Span span1 = new Span("description", 0, 8, "ORGANIZATION", "Microsoft");
        spanList.add(span1);
        IField spanField = new ListField<Span>(spanList);
        fields.add(spanField);
        ITuple resultTuple = new DataTuple(new Schema(SchemaConstants.SPAN_LIST_ATTRIBUTE), fields.toArray(new IField[fields.size()]));
        resultList.add(resultTuple);
        return resultList;
    }

    public static List<ITuple> getTest2ResultTuples() {
        List<ITuple> resultList= new ArrayList<>();
        List<IField> fields = new ArrayList<IField>();
        List<Span> spanList = new ArrayList<Span>();
        Span span1 = new Span("description", 0, 8, "ORGANIZATION", "Microsoft");
        Span span2 = new Span("description", 10, 15, "ORGANIZATION", "Google");
        Span span3 = new Span("description", 21, 28, "ORGANIZATION", "Facebook");
        spanList.add(span1);
        spanList.add(span2);
        spanList.add(span3);
        IField spanField = new ListField<Span>(spanList);
        fields.add(spanField);
        ITuple resultTuple = new DataTuple(new Schema(SchemaConstants.SPAN_LIST_ATTRIBUTE), fields.toArray(new IField[fields.size()]));
        resultList.add(resultTuple);
        return resultList;
    }

    public static List<ITuple> getTest3ResultTuples() {
        List<ITuple> resultList= new ArrayList<>();

        List<IField> fields = new ArrayList<IField>();
        List<Span> spanList = new ArrayList<Span>();
        Span span1 = new Span("description", 0, 8, "ORGANIZATION", "Microsoft");
        Span span2 = new Span("description", 10, 15, "ORGANIZATION", "Google");
        Span span3 = new Span("description", 21, 28, "ORGANIZATION", "Facebook");
        Span span4 = new Span("description", 52, 63, "PERSON", "Donald Trump");
        Span span5 = new Span("description", 69, 80, "PERSON", "Barack Obama");

        spanList.add(span1);
        spanList.add(span2);
        spanList.add(span3);
        spanList.add(span4);
        spanList.add(span5);

        IField spanField = new ListField<Span>(spanList);
        fields.add(spanField);
        ITuple resultTuple = new DataTuple(new Schema(SchemaConstants.SPAN_LIST_ATTRIBUTE), fields.toArray(new IField[fields.size()]));
        resultList.add(resultTuple);
        return resultList;
    }



}
