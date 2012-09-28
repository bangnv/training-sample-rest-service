/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.cross.rest.test;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

/**
 * Created by The eXo Platform SAS Author : Nguyen Viet Bang
 * bangnv@exoplatform.com Sep 27, 2012
 */
public class CalculServiceTest extends JerseyTest {
  private final String       urlHost     = "http://localhost:8080/";

  private static WebResource webResource = null;

  @Override
  protected AppDescriptor configure() {
    return new WebAppDescriptor.Builder().build();
  }

  @Override
  public void setUp() throws Exception {
    webResource = client().resource(urlHost);
  }

  
  @Test
  public void testPlusOperator() throws URISyntaxException {
    String result = webResource.path("/rest/calculService/plus/1/2").get(String.class);
    assertEquals("3.0", result);
  }

   public void testSubsOperator(){
    String result = webResource.path("/rest/calculService/subs/1/2").get(String.class);
    assertEquals("0.5",result);
   }
   
   
   public void testMultiOperator(){
     String result = webResource.path("/rest/calculService/multi/5/10").get(String.class);
     assertEquals("50.0",result);
    }
   
   
   
   public void testDivOperator(){
     String result = webResource.path("/rest/calculService/div/10/50").get(String.class);
     assertEquals("0.2",result);
    }
   
   
   
   
   
   
   

}
