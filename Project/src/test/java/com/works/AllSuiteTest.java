package com.works;

import com.works.customer.CustomerMockRestTest;
import com.works.utils.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("All Suite Test-1")
// Config
//@SelectPackages(value = {"com.works.customer"})
@SelectPackages(value = {""})
//@IncludeTags(Util.rest)
//@IncludeClassNamePatterns("^.*Customer.*")
@ExcludeTags(Util.rest)
public class AllSuiteTest {
}
