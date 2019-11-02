package me.whiteship.ksug2019.study;

import lombok.Data;

@Data
public class TagCloudData {

    private String x;

    private long value;

    public TagCloudData(String x, long value) {
        this.x = x;
        this.value = value;
    }
}
