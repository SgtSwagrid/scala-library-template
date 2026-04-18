package com.alecdorrington

class ExampleSuite extends munit.FunSuite:

  test("hello returns the expected greeting"):
    assertEquals(Example.hello, "Hello, World!")
