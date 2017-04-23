/*
 * Copyright (C) 2017 Dominik Schadow, dominikschadow@gmail.com
 *
 * This file is part of the Cloud Security project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dominikschadow.configclient.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Tests the [@link CredentialsController} class.
 *
 * @author Dominik Schadow
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CredentialsController.class)
public class CredentialsControllerTest {
    @MockBean
    private CredentialsRepository credentialsRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllCredentialsReturnsOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/credentials")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getSingleCredentialCReturnsOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/credentials/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}