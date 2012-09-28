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
package org.exoplatform.cross.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.exoplatform.services.rest.resource.ResourceContainer;

/**
 * Created by The eXo Platform SAS Author : Nguyen Viet Bang
 * bangnv@exoplatform.com Sep 26, 2012
 */



@Path("/stringService/")
public class StringService implements ResourceContainer {

  //Exemple  http://localhost:8080/rest/stringService/reverse/exo
  @GET
  @Path("/reverse/{input}")
  public String reverse(@PathParam("input")
  String input) {
    return new StringBuffer(input).reverse().toString();
  }

//Exemple  http://localhost:8080/rest/stringService/mixString/Ha/An
  @GET
  @Path("/mixString/{str1}/{str2}")
  public String mixTwoString(@PathParam("str1")
  String str1, @PathParam("str2")
  String str2) {
    StringBuffer sb1 = new StringBuffer(str1);
    StringBuffer sb2 = new StringBuffer(str2);
    StringBuffer result = new StringBuffer();
    int length = (sb1.length() > sb2.length()) ? sb2.length() : sb1.length();
    for (int i = 0; i < length; i++) {
      result.append(sb1.charAt(i)).append(sb2.charAt(i));
    }
    if (sb1.length() > length) {
      result.append(sb1.substring(length));
    } else if (sb2.length() > length) {
      result.append(sb2.substring(length));
    }
    return result.toString();
  }

}
