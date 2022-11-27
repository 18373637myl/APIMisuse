package com.apimisuse.detector.dot;

import com.apimisuse.aug.model.Edge;
import com.apimisuse.aug.model.dot.AUGEdgeAttributeProvider;
import com.apimisuse.detector.model.Overlap;

import java.util.Map;

class OverlapEdgeAttributeProvider extends AUGEdgeAttributeProvider {
    private final Overlap violation;
    private final String unmappedNodeColor;

    OverlapEdgeAttributeProvider(Overlap violation, String unmappedNodeColor) {
        this.unmappedNodeColor = unmappedNodeColor;
        this.violation = violation;
    }

    @Override
    public Map<String, String> getComponentAttributes(Edge edge) {
        final Map<String, String> attributes = super.getComponentAttributes(edge);
        if (!violation.mapsEdge(edge)) {
            attributes.put("color", unmappedNodeColor);
            attributes.put("fontcolor", unmappedNodeColor);
        }
        return attributes;
    }
}
