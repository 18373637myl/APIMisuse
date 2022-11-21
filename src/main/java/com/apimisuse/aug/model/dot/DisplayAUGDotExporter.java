package com.apimisuse.aug.model.dot;

import com.apimisuse.aug.visitors.BaseAUGLabelProvider;
import com.apimisuse.aug.visitors.WithSourceLineNumberLabelProvider;

public class DisplayAUGDotExporter extends AUGDotExporter {
    public DisplayAUGDotExporter() {
        super(new WithSourceLineNumberLabelProvider(new BaseAUGLabelProvider()),
                new AUGNodeAttributeProvider(),
                new AUGEdgeAttributeProvider());
    }
}
