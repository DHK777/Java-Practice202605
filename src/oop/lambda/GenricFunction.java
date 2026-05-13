package oop.lambda;

@FunctionalInterface
public interface GenricFunction<X, Y> {

    // X에서 Y를 추출해 줄게
    Y apply(X x);
}
