package com.ju5.params;

public class Strings {
    public long countVowels(String in) {
        long count = 0;

        if(in == null) {
            return count;
        }

        count = in.chars()
                .filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u').count();

        return count;
    }
}
