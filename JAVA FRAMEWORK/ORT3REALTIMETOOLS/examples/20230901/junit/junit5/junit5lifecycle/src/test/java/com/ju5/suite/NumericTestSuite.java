package com.ju5.suite;

import com.ju5.core.NumberHelperTest;
import com.ju5.core.UnitsConverterTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({NumberHelperTest.class, UnitsConverterTest.class})
public class NumericTestSuite {
}
