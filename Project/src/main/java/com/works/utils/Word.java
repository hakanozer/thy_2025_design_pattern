package com.works.utils;

import com.works.impls.IDocument;

public class Word implements IDocument {

    @Override
    public void print() {
        System.out.println("Word print");
    }

}
