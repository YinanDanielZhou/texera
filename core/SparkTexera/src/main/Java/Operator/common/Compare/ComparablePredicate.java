package Operator.common.Compare;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import Operator.OperatorGroupConstants;
import Exception.TexeraException;
import Operator.Base.OperatorBase;
import Operator.Base.PredicateBase;
import Utility.PropertyNameConstants;

/**
 *
 * @author Adrian Seungjin Lee
 * @author Zuozhi Wang
 */
public class ComparablePredicate extends PredicateBase {

    private String attributeName;
    private Object compareToValue;
    private ComparisonType matchingType;

    @JsonCreator
    public ComparablePredicate(
            @JsonProperty(value = PropertyNameConstants.ATTRIBUTE_NAME, required = true)
            String attributeName,
            @JsonProperty(value = PropertyNameConstants.COMPARISON_TYPE, required = true)
            ComparisonType matchingType,
            @JsonProperty(value = PropertyNameConstants.COMPARE_TO_VALUE, required = true)
            Object compareToValue) {
        if (attributeName == null || attributeName.trim().isEmpty()) {
            throw new TexeraException("attribute cannot be empty");
        }
        this.compareToValue = compareToValue;
        this.attributeName = attributeName;
        this.matchingType = matchingType;
    }
    
    @JsonProperty(value = PropertyNameConstants.ATTRIBUTE_NAME)
    public String getAttributeName() {
        return attributeName;
    }

    @JsonProperty(value = PropertyNameConstants.COMPARISON_TYPE)
    public ComparisonType getComparisonType() {
        return matchingType;
    }

    @JsonProperty(value = PropertyNameConstants.COMPARE_TO_VALUE)
    public Object getCompareToValue() {
        return compareToValue;
    }

    @Override
    public OperatorBase newOperator() {
        return new ComparableMatcher(this);
    }
    
    public static Map<String, Object> getOperatorMetadata() {
        return ImmutableMap.<String, Object>builder()
            .put(PropertyNameConstants.USER_FRIENDLY_NAME, "Spark Comparison")
            .put(PropertyNameConstants.OPERATOR_DESCRIPTION, "Select data based on a condition (>, <, =, ..)")
            .put(PropertyNameConstants.OPERATOR_GROUP_NAME, OperatorGroupConstants.UTILITY_GROUP)
            .build();
    }

}