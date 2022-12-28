package com.mangu.congreso_api.web.rest;

import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;
import java.util.Arrays;
import java.util.List;

public class TestTuple implements Tuple {

  private final Object[] a;

  public TestTuple(Object[] a) {
    this.a = a;
  }

  @Override
  public <X> X get(TupleElement<X> tupleElement) {
    return null;
  }

  @Override
  public <X> X get(String alias, Class<X> type) {
    return null;
  }

  @Override
  public Object get(String alias) {
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T get(int index, Class<T> type) {
    return (T) a[index];
  }

  @Override
  public Object get(int i) {
    return null;
  }


  @Override
  public Object[] toArray() {
    return a;
  }

  @Override
  public List<TupleElement<?>> getElements() {
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    } else if (obj instanceof Tuple tuple) {
      return Arrays.equals(a, tuple.toArray());
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(a);
  }

  @Override
  public String toString() {
    return Arrays.toString(a);
  }

}