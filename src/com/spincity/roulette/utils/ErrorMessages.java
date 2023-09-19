package com.spincity.roulette.utils;

import static com.spincity.roulette.utils.ANSI.colorRed;

public class ErrorMessages {
    public static String errorMessageInvalidSelection() {
        return colorRed("Invalid Selection!") + " Please try again.\n\n";
    }

    public static String errorMessageInvalidEntry() {
        return colorRed("Invalid Entry!") + " Please try again.\n\n";
    }


}
