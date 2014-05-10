package org.cen.com;

import org.cen.com.documentation.ComDataDocumentationMethodSignatureBuilderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { ComDataUtilsTest.class, DefaultDecoderTest.class,
        ComDataDocumentationMethodSignatureBuilderTest.class })
public class CenCommunicationTestSuite {

}
