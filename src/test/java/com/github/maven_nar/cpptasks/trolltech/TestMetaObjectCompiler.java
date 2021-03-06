/*
 * #%L
 * Native ARchive plugin for Maven
 * %%
 * Copyright (C) 2002 - 2014 NAR Maven Plugin developers.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.maven_nar.cpptasks.trolltech;

import com.github.maven_nar.cpptasks.compiler.AbstractProcessor;
import com.github.maven_nar.cpptasks.compiler.TestAbstractCompiler;

/**
 * Tests for Trolltech Meta Object Compiler.
 *
 */
public class TestMetaObjectCompiler extends TestAbstractCompiler {
  /**
   * Constructor.
   * 
   * @param name
   *          test name
   */
  public TestMetaObjectCompiler(final String name) {
    super(name);
  }

  /**
   * Creates compiler for inherited tests.
   * 
   * @return AbstractProcessor compiler
   */
  @Override
  protected AbstractProcessor create() {
    return MetaObjectCompiler.getInstance();
  }

  /**
   * Override inherited test.
   */
  @Override
  public void failingtestGetOutputFileName1() {
    final AbstractProcessor compiler = MetaObjectCompiler.getInstance();
    String[] output = compiler.getOutputFileNames("c:/foo\\bar\\hello.cpp", null);
    assertEquals("hello" + getObjectExtension(), output[0]);
    output = compiler.getOutputFileNames("c:/foo\\bar/hello.cpp", null);
    assertEquals("hello" + getObjectExtension(), output[0]);
    output = compiler.getOutputFileNames("hello.cpp", null);
    assertEquals("hello" + getObjectExtension(), output[0]);
    output = compiler.getOutputFileNames("c:/foo\\bar\\hello.h", null);
    assertEquals("moc_hello.cpp", output[0]);
    output = compiler.getOutputFileNames("c:/foo\\bar/hello.h", null);
    assertNull("moc_hello.cpp", output[0]);
  }

  /**
   * Gets default output file extension.
   * 
   * @return String output file extension
   */
  @Override
  protected String getObjectExtension() {
    return ".moc";
  }

  /**
   * Skip testGetIdentifier.
   */
  @Override
  public void testGetIdentfier() {
  }
}
