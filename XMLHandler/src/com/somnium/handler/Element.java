package com.somnium.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Element {
    private Element parent;
    private HashMap<String, String> attributes = new HashMap<>();
    private ArrayList<Element> childElements = new ArrayList<>();
    private String value;
    private String name;

    Element() {

    }

    public Element(core.Attribute... a) {
        Arrays.stream(a).forEach(attribute -> attributes.put(attribute.getName(), attribute.getValue()));
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public ArrayList<Element> getChildElements() {
        return childElements;
    }
    public Element getChildElementByName(String name){
        AtomicReference<Element> returned = new AtomicReference<>();
        getChildElements().forEach(element -> {
            if (element.getName().equals(name)){
                returned.set(element);
            }
        });
        return returned.get();
    }
    boolean containsAllChildesByName(String... strings){
        ArrayList<String> names = new ArrayList<>();
        getChildElements().forEach(element -> names.add(element.getName()));
        for (String name : strings) {
            if (!names.contains(name))return false;
        }
        return true;
    }
    public boolean containsChildByName(String name){
        ArrayList<String> names = new ArrayList<>();
        getChildElements().forEach(element -> names.add(element.getName()));
        return names.contains(name);
    }

    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
