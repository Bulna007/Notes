package com.jbvc.groups;

import jakarta.validation.Payload;

public class Severity {
    public static interface Critical extends Payload {
    }

    public static interface Warn extends Payload{
    }

    public static interface Minor extends Payload{
    }

}
