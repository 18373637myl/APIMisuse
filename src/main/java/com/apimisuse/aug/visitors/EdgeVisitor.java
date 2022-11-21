package com.apimisuse.aug.visitors;

import com.apimisuse.aug.model.controlflow.*;
import com.apimisuse.aug.model.dataflow.DefinitionEdge;
import com.apimisuse.aug.model.dataflow.ParameterEdge;
import com.apimisuse.aug.model.dataflow.QualifierEdge;
import com.apimisuse.aug.model.dataflow.ReceiverEdge;

public interface EdgeVisitor<R> {
    // Control Flow
    R visit(ContainsEdge edge);
    R visit(ExceptionHandlingEdge edge);
    R visit(FinallyEdge edge);
    R visit(OrderEdge edge);
    R visit(RepetitionEdge edge);
    R visit(SelectionEdge edge);
    R visit(SynchronizationEdge edge);
    R visit(ThrowEdge edge);
    // Data Flow
    R visit(DefinitionEdge edge);
    R visit(ParameterEdge edge);
    R visit(QualifierEdge edge);
    R visit(ReceiverEdge edge);
}
