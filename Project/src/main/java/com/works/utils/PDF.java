package com.works.utils;

import com.works.impls.IDocument;

public class PDF implements IDocument {

    @Override
    public void print() {
        System.out.println("PDF Print");
    }

}
