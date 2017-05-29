package com.mobiquityinc.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Domain object for the ItemPackage
 *
 * Created by Mithilesh Ravindran .
 */
public class ItemPackage {

    private double weightLimit;

    private List<Item> items;

    private String exceptionReason;

    public ItemPackage(double weightLimit , List<Item> items) {
        this.weightLimit = weightLimit;
        this.items = items;
    }

    public double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getExceptionReason() {
        return exceptionReason;
    }

    public void setExceptionReason(String exceptionReason) {
        this.exceptionReason = exceptionReason;
    }

    @Override
    public String toString() {
        if (items == null || items.isEmpty())
            return "-";

        if (items != null && StringUtils.isNotBlank(exceptionReason))
            return exceptionReason;

        return items.stream().map(thing -> String.valueOf(thing.getId())).collect(Collectors.joining(", "));
    }
}
