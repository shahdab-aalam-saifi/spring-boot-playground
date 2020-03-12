package com.saalamsaifi.playground.springboot.service.impl;

import com.saalamsaifi.playground.springboot.service.Operation;
import org.springframework.stereotype.Service;

@Service
public class Multiplication implements Operation {
  @Override
  public boolean handles(char op) {
    return '*' == op;
  }

  @Override
  public int apply(int lhs, int rhs) {
    return lhs * rhs;
  }
}
