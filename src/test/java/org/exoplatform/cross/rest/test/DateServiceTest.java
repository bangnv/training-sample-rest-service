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

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

/**
 * Created by The eXo Platform SAS Author : Nguyen Viet Bang
 * bangnv@exoplatform.com Sep 27, 2012
 */
public class DateServiceTest extends JerseyTest {

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
  public void testDiffDate() {

    String result1 = webResource.path("/rest/dateService/diffDate/11-05-2011/13-05-2011/Min")
                                .get(String.class);
    assertEquals("2880", result1);

    String result2 = webResource.path("/rest/dateService/diffDate/11-05-2011/13-05-2011/Hour")
                                .get(String.class);
    assertEquals("48", result2);

    String result3 = webResource.path("/rest/dateService/diffDate/11-05-2011/13-05-2011/Day")
                                .get(String.class);
    assertEquals("2", result3);

  }

}
