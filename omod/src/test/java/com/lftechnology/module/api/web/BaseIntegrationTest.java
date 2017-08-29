package com.lftechnology.module.api.web;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(locations = "classpath:TestingApplicationContext.xml")
@WebAppConfiguration
public class BaseIntegrationTest {
}
