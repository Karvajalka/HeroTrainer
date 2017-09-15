package com.satgnu.herotrainer.entity;

import java.util.HashMap;
import java.util.Map;

public class BaseAttributes {

    public enum Attribute
    {
        Physical,
        Agility,
        Mind;
    }

    private Map<Integer, Integer> attributes = new HashMap<>();

    public int GetAttribute(BaseAttributes.Attribute attr)
    {
        return attributes.get(attr.ordinal());
    }

    public void SetAttribute(BaseAttributes.Attribute attr, int val)
    {
        attributes.put(attr.ordinal(), val);
    }
}
