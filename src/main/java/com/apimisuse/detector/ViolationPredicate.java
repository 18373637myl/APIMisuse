package com.apimisuse.detector;

import com.apimisuse.detector.model.Overlap;

import java.util.Optional;
import java.util.function.Function;

public interface ViolationPredicate extends Function<Overlap, Optional<Boolean>> {}
