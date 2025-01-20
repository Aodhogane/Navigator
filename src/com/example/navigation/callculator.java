package com.example.navigation;

import com.example.navigation.structura.structurImpl.MyArrayListIml;

public class callculator {

    public callculator() {
    }

    public static int calculatePoint(MyArrayListIml<String> points, String startPoint, String endPoint) {
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).equals(startPoint)) {
                startIndex = i;
            }
            if (points.get(i).equals(endPoint)) {
                endIndex = i;
            }

            if (startIndex != -1 && endIndex != -1) {
                break;
            }
        }

        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            return endIndex - startIndex;
        }

        return Integer.MAX_VALUE;
    }
}
