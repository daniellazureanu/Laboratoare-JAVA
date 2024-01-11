package com.DanielLazureanu.SpringService;

public class CsvData implements Comparable<CsvData>{
    String category;
    String region;
    int year;
    String unit;
    double value;

    public CsvData(String category, String region, int year, String unit, double value) {
        this.category = category;
        this.region = region;
        this.year = year;
        this.unit = unit;
        this.value = value;
    }

    public int compareTo(CsvData other){
        return Integer.compare(this.year, other.year);
    }

    @Override
    public String toString() {
        return  "category=" + category +
                ", region=" + region +
                ", year=" + year +
                ", unit=" + unit +
                ", value=" + value;
    }
}