package com.atl.edusoftware.commons


class Utils {

    static Boolean numericToBoolean(def input) {
        return input == 1
    }

    static Boolean nullOrZero(def input) {
        return input == null || input == 0
    }
}
