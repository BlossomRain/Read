package ch03;

import java.util.Objects;

/**
 *  Broken - violates symmetry!
 */
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }


    // Broken - violates symmetry!
    /*@Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);

        if (o instanceof String) // One-way interoperability!
            return s.equalsIgnoreCase((String) o);

        return false;
    }*/
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString
                && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
    // Remainder omitted ...

    public static void main(String[] args){
        String s1 = "Hello";
        CaseInsensitiveString s2 = new CaseInsensitiveString("hello");
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
    }
}